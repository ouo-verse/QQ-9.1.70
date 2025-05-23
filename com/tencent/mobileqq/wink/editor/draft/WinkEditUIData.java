package com.tencent.mobileqq.wink.editor.draft;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.editor.d;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
/* loaded from: classes21.dex */
public abstract class WinkEditUIData implements Serializable {
    private static final long serialVersionUID = 1305287458990105944L;
    private ConcurrentHashMap<String, Integer> mIntMap;
    private ConcurrentHashMap<String, Serializable> mSerializableMap;
    private ConcurrentHashMap<String, String> mStrMap;
    private String mUITag;

    WinkEditUIData() {
        this.mSerializableMap = new ConcurrentHashMap<>();
        this.mStrMap = new ConcurrentHashMap<>();
        this.mIntMap = new ConcurrentHashMap<>();
        this.mUITag = "WinkEditUIData";
    }

    private <T> T getValue(String str, T t16, ConcurrentHashMap<String, T> concurrentHashMap) {
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str);
        }
        return t16;
    }

    public boolean getBoolean(String str, boolean z16) {
        if (((Integer) getValue(str, Integer.valueOf(z16 ? 1 : 0), this.mIntMap)).intValue() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getInt(String str, int i3) {
        return ((Integer) getValue(str, Integer.valueOf(i3), this.mIntMap)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Serializable getSerializable(String str, Serializable serializable) {
        return (Serializable) getValue(str, serializable, this.mSerializableMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getString(String str, String str2) {
        return (String) getValue(str, str2, this.mStrMap);
    }

    public boolean isCurrentTag(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mUITag) && str.equals(this.mUITag)) {
            return true;
        }
        return false;
    }

    public void putBoolean(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mIntMap.put(str, Integer.valueOf(z16 ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putInt(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mIntMap.put(str, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putSerializable(String str, Serializable serializable) {
        if (!TextUtils.isEmpty(str) && serializable != null) {
            this.mSerializableMap.put(str, serializable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mStrMap.put(str, str2);
        }
    }

    @NonNull
    public String toString() {
        return "mIntMap:" + this.mIntMap.toString() + ", mStrMap:" + this.mStrMap.toString();
    }

    public final WinkEditUIData updateData() {
        updateInner();
        return this;
    }

    protected abstract void updateInner();

    public WinkEditUIData(@NotNull d dVar) {
        this.mSerializableMap = new ConcurrentHashMap<>();
        this.mStrMap = new ConcurrentHashMap<>();
        this.mIntMap = new ConcurrentHashMap<>();
        this.mUITag = "WinkEditUIData";
        this.mUITag = dVar.getLogTag();
    }

    public WinkEditUIData(@NotNull BaseViewModel baseViewModel) {
        this.mSerializableMap = new ConcurrentHashMap<>();
        this.mStrMap = new ConcurrentHashMap<>();
        this.mIntMap = new ConcurrentHashMap<>();
        this.mUITag = "WinkEditUIData";
        this.mUITag = baseViewModel.getLogTag();
    }

    public void recovery() {
    }
}
