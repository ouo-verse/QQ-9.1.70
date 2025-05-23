package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Coder;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class SpService implements ISpOperation {
    private static final String TAG = "SpService";
    private Context mContext;
    private Coder mCoder = new GsonObjectCoder();
    private AnnotationProcessor mAnnotationProcessor = AnnotationProcessor.getInstance();

    public SpService(Context context) {
        this.mContext = context;
    }

    private void clear() {
        SharedPreferences.Editor edit = initSp(this.mContext).edit();
        edit.clear();
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }

    private String getString(String str, String str2) {
        return initSp(this.mContext).getString(str, str2);
    }

    private SharedPreferences initSp(Context context) {
        return context.getSharedPreferences("datong_storage", 0);
    }

    private void removeString(String str) {
        SharedPreferences.Editor edit = initSp(this.mContext).edit();
        edit.remove(str);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }

    private void saveString(String str, String str2) {
        SharedPreferences.Editor edit = initSp(this.mContext).edit();
        edit.putString(str, str2);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(edit);
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public void clearSp() {
        clear();
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> boolean containsObject(Class<T> cls, String str) {
        String string = getString(this.mAnnotationProcessor.getClassId(cls), null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            return new JSONObject(string).has(str);
        } catch (Error e16) {
            Log.e(TAG, "containsObject, error: " + e16.getLocalizedMessage());
            return false;
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
            return false;
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteAllObjects(Class<T> cls) {
        removeString(this.mAnnotationProcessor.getClassId(cls));
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteObject(Class<T> cls, String str) {
        String classId = this.mAnnotationProcessor.getClassId(cls);
        String string = getString(classId, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            jSONObject.remove(str);
            saveString(classId, jSONObject.toString());
        } catch (Error e16) {
            Log.e(TAG, "deleteObject, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void deleteObjects(Class<T> cls, List<String> list) {
        String classId = this.mAnnotationProcessor.getClassId(cls);
        String string = getString(classId, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                jSONObject.remove(list.get(i3));
            }
            saveString(classId, jSONObject.toString());
        } catch (Error e16) {
            Log.e(TAG, "deleteObjects, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> List<Pair<String, T>> getAllObjects(Class<T> cls) {
        LinkedList linkedList = new LinkedList();
        String string = getString(this.mAnnotationProcessor.getClassId(cls), null);
        if (TextUtils.isEmpty(string)) {
            return linkedList;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object decode = this.mCoder.decode(jSONObject.getString(str), cls);
                if (decode != null) {
                    linkedList.add(new Pair(str, decode));
                }
            }
        } catch (Error e16) {
            Log.e(TAG, "getAllObjects, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> T getObject(Class<T> cls, String str) {
        String str2 = null;
        String string = getString(this.mAnnotationProcessor.getClassId(cls), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            str2 = new JSONObject(string).getString(str);
        } catch (Error e16) {
            Log.e(TAG, "getObject, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
        return (T) this.mCoder.decode(str2, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> List<Pair<String, T>> getObjects(Class<T> cls, Condition<T> condition) {
        LinkedList linkedList = new LinkedList();
        String string = getString(this.mAnnotationProcessor.getClassId(cls), null);
        if (TextUtils.isEmpty(string)) {
            return linkedList;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object decode = this.mCoder.decode(jSONObject.getString(str), cls);
                if (condition == 0 || condition.satisfy(decode)) {
                    linkedList.add(new Pair(str, decode));
                }
            }
        } catch (Error e16) {
            Log.e(TAG, "getObjects, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
        return linkedList;
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void insertObject(T t16, String str) {
        JSONObject jSONObject;
        String classId = this.mAnnotationProcessor.getClassId(t16.getClass());
        String string = getString(classId, null);
        try {
            if (string != null) {
                jSONObject = new JSONObject(string);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str, this.mCoder.encode(t16));
            saveString(classId, jSONObject.toString());
        } catch (Error e16) {
            Log.e(TAG, "insertObject, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.storage.preference.ISpOperation
    public <T> void insertObjects(List<T> list, List<String> list2) {
        JSONObject jSONObject;
        if (list.isEmpty()) {
            return;
        }
        String classId = this.mAnnotationProcessor.getClassId(list.get(0).getClass());
        String string = getString(classId, null);
        try {
            if (string != null) {
                jSONObject = new JSONObject(string);
            } else {
                jSONObject = new JSONObject();
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                jSONObject.put(list2.get(i3), this.mCoder.encode(list.get(i3)));
            }
            saveString(classId, jSONObject.toString());
        } catch (Error e16) {
            Log.e(TAG, "insertObjects, error: " + e16.getLocalizedMessage());
        } catch (JSONException e17) {
            Log.e(TAG, "json parse failure, error: " + e17.getLocalizedMessage());
        }
    }
}
