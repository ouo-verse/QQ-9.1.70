package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private OnChooseActivityListener mActivityChoserModelPolicy;
    final Context mContext;
    final String mHistoryFileName;
    private Intent mIntent;
    private static final Object sRegistryLock = new Object();
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private final Object mInstanceLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private ActivitySorter mActivitySorter = new DefaultSorter();
    private int mHistoryMaxSize = 50;
    boolean mCanReadHistoricalData = true;
    private boolean mReadShareHistoryCalled = false;
    private boolean mHistoricalRecordsChanged = true;
    private boolean mReloadActivities = false;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        @Override // java.lang.Comparable
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        DefaultSorter() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ActivityResolveInfo activityResolveInfo = list.get(i3);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f16 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f16;
                    f16 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j3, float f16) {
            this(ComponentName.unflattenFromString(str), j3, f16);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            if (this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                hashCode = 0;
            } else {
                hashCode = componentName.hashCode();
            }
            long j3 = this.time;
            return ((((hashCode + 31) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal(this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j3, float f16) {
            this.activity = componentName;
            this.time = j3;
            this.weight = f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0072, code lost:
        
            if (r15 != null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x00da, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
        
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b7, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
        
            if (r15 == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d7, code lost:
        
            if (r15 == null) goto L30;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = ActivityChooserModel.this.mContext.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            newSerializer.setOutput(openFileOutput, null);
                            newSerializer.startDocument("UTF-8", Boolean.TRUE);
                            newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                            int size = list.size();
                            for (int i3 = 0; i3 < size; i3++) {
                                HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                                newSerializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                                newSerializer.attribute(null, "activity", historicalRecord.activity.flattenToString());
                                newSerializer.attribute(null, "time", String.valueOf(historicalRecord.time));
                                newSerializer.attribute(null, "weight", String.valueOf(historicalRecord.weight));
                                newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                            }
                            newSerializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                            newSerializer.endDocument();
                            ActivityChooserModel.this.mCanReadHistoricalData = true;
                        } catch (IOException e16) {
                            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.mHistoryFileName, e16);
                            ActivityChooserModel.this.mCanReadHistoricalData = true;
                        } catch (IllegalArgumentException e17) {
                            Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.mHistoryFileName, e17);
                            ActivityChooserModel.this.mCanReadHistoricalData = true;
                        }
                    } catch (IllegalStateException e18) {
                        Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + ActivityChooserModel.this.mHistoryFileName, e18);
                        ActivityChooserModel.this.mCanReadHistoricalData = true;
                    }
                } catch (Throwable th5) {
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th5;
                }
            } catch (FileNotFoundException e19) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical record file: " + str, e19);
                return null;
            }
        }
    }

    ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
            return;
        }
        this.mHistoryFileName = str;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean add = this.mHistoricalRecords.add(historicalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return add;
    }

    private void ensureConsistentState() {
        boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            Map<String, ActivityChooserModel> map = sDataModelRegistry;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(this.mContext.getPackageManager(), this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mActivities.add(new ActivityResolveInfo(queryIntentActivities.get(i3)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (this.mReadShareHistoryCalled) {
            if (!this.mHistoricalRecordsChanged) {
                return;
            }
            this.mHistoricalRecordsChanged = false;
            if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.mHistoricalRecords), this.mHistoryFileName);
                return;
            }
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size <= 0) {
            return;
        }
        this.mHistoricalRecordsChanged = true;
        for (int i3 = 0; i3 < size; i3++) {
            this.mHistoricalRecords.remove(0);
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private void readHistoricalDataImpl() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(this.mHistoryFileName);
            try {
                try {
                    newPullParser = Xml.newPullParser();
                    newPullParser.setInput(openFileInput, "UTF-8");
                    for (int i3 = 0; i3 != 1 && i3 != 2; i3 = newPullParser.next()) {
                    }
                } catch (IOException e16) {
                    Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e16);
                    if (openFileInput == null) {
                        return;
                    }
                } catch (XmlPullParserException e17) {
                    Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, e17);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (TAG_HISTORICAL_RECORDS.equals(newPullParser.getName())) {
                    List<HistoricalRecord> list = this.mHistoricalRecords;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (next != 3 && next != 4) {
                            if (TAG_HISTORICAL_RECORD.equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (Throwable th5) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th5;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
            this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
            return true;
        }
        return false;
    }

    public Intent chooseActivity(int i3) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityInfo activityInfo = this.mActivities.get(i3).resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo getActivity(int i3) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i3).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> list = this.mActivities;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (list.get(i3).resolveInfo == resolveInfo) {
                    return i3;
                }
            }
            return -1;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (!this.mActivities.isEmpty()) {
                return this.mActivities.get(0).resolveInfo;
            }
            return null;
        }
    }

    public int getHistoryMaxSize() {
        int i3;
        synchronized (this.mInstanceLock) {
            i3 = this.mHistoryMaxSize;
        }
        return i3;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setDefaultActivity(int i3) {
        float f16;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            ActivityResolveInfo activityResolveInfo = this.mActivities.get(i3);
            ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
            if (activityResolveInfo2 != null) {
                f16 = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
            } else {
                f16 = 1.0f;
            }
            ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
            addHistoricalRecord(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f16));
        }
    }

    public void setHistoryMaxSize(int i3) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == i3) {
                return;
            }
            this.mHistoryMaxSize = i3;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
