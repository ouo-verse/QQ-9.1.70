package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc010001 {
    public static final String KEY_ACTIONTYPE = "actiontype";
    public static final String KEY_APP_ID = "app_id";
    public static final String KEY_BUSIMSGID = "busiMsgId";
    public static final String KEY_EEVEEMSGID = "eeveeMsgId";
    public static final String KEY_MAINTYPE = "mainType";
    public static final String KEY_RESERVES = "thr_action";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_SUBACTIONTYPE = "subactiontype";
    public static final String KEY_SUBTYPE = "subType";
    private static final String TAG = "QCircleLpReportDc010001";

    static /* synthetic */ int access$800() {
        return getDcId();
    }

    static void doReportInner(final DataBuilder dataBuilder) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc010001.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("actiontype", String.valueOf(DataBuilder.this.actionType)), QCircleReportHelper.newEntry("subactiontype", String.valueOf(DataBuilder.this.subActionType)), QCircleReportHelper.newEntry("thr_action", String.valueOf(DataBuilder.this.thrActionType)), QCircleReportHelper.newEntry(QCircleLpReportDc010001.KEY_MAINTYPE, String.valueOf(DataBuilder.this.mainType)), QCircleReportHelper.newEntry(QCircleLpReportDc010001.KEY_SUBTYPE, String.valueOf(DataBuilder.this.subType)), QCircleReportHelper.newEntry(QCircleLpReportDc010001.KEY_BUSIMSGID, DataBuilder.this.busiMsgId), QCircleReportHelper.newEntry(QCircleLpReportDc010001.KEY_EEVEEMSGID, DataBuilder.this.eeveeMsgId), QCircleReportHelper.newEntry("scene", String.valueOf(DataBuilder.this.scene)), QCircleReportHelper.newEntry("app_id", String.valueOf(10000))));
                arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
                QCircleReporter.getInstance().add(QCircleReportHelper.newSingleDcData(QCircleLpReportDc010001.access$800(), arrayList, null, null), true);
            }
        });
    }

    private static int getDcId() {
        return 10001;
    }

    public static void report(DataBuilder dataBuilder) {
        if (dataBuilder == null) {
            QLog.e(TAG, 1, "DataBuilder == null");
        } else {
            doReportInner(dataBuilder);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DataBuilder {
        private int actionType;
        private String busiMsgId = "";
        private String eeveeMsgId = "";
        private int mainType;
        private int scene;
        private int subActionType;
        private int subType;
        private int thrActionType;

        public DataBuilder() {
        }

        public int getActionType() {
            return this.actionType;
        }

        public String getBusiMsgId() {
            return this.busiMsgId;
        }

        public String getEeveeMsgId() {
            return this.eeveeMsgId;
        }

        public int getMainType() {
            return this.mainType;
        }

        public int getScene() {
            return this.scene;
        }

        public int getSubActionType() {
            return this.subActionType;
        }

        public int getSubType() {
            return this.subType;
        }

        public int getThrActionType() {
            return this.thrActionType;
        }

        public DataBuilder setActionType(int i3) {
            this.actionType = i3;
            return this;
        }

        public DataBuilder setBusiMsgId(String str) {
            this.busiMsgId = str;
            return this;
        }

        public DataBuilder setEeveeMsgId(String str) {
            this.eeveeMsgId = str;
            return this;
        }

        public DataBuilder setMainType(int i3) {
            this.mainType = i3;
            return this;
        }

        public DataBuilder setScene(int i3) {
            this.scene = i3;
            return this;
        }

        public DataBuilder setSubActionType(int i3) {
            this.subActionType = i3;
            return this;
        }

        public DataBuilder setSubType(int i3) {
            this.subType = i3;
            return this;
        }

        public DataBuilder setThrActionType(int i3) {
            this.thrActionType = i3;
            return this;
        }

        public DataBuilder(QCircleLpReportDc010001DataBuilder qCircleLpReportDc010001DataBuilder) {
            if (qCircleLpReportDc010001DataBuilder == null) {
                return;
            }
            setActionType(qCircleLpReportDc010001DataBuilder.getActionType()).setSubActionType(qCircleLpReportDc010001DataBuilder.getSubActionType()).setThrActionType(qCircleLpReportDc010001DataBuilder.getThrActionType()).setMainType(qCircleLpReportDc010001DataBuilder.getMainType()).setSubType(qCircleLpReportDc010001DataBuilder.getSubType()).setBusiMsgId(qCircleLpReportDc010001DataBuilder.getBusiMsgId()).setEeveeMsgId(qCircleLpReportDc010001DataBuilder.getEeveeMsgId()).setScene(qCircleLpReportDc010001DataBuilder.getScene());
        }
    }
}
