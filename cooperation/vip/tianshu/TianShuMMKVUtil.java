package cooperation.vip.tianshu;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianShuMMKVUtil {
    private static final String TAG = "TianShuMMKVUtil";
    private static volatile TianShuMMKVUtil sAccountInstance;
    private final KeyDelegate mDelegate;
    private final MMKVOptionEntity mEntity;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface KeyDelegate {
        String getKey(String str);
    }

    TianShuMMKVUtil(MMKVOptionEntity mMKVOptionEntity, KeyDelegate keyDelegate) {
        this.mEntity = mMKVOptionEntity;
        this.mDelegate = keyDelegate;
    }

    public static TianShuMMKVUtil g(final String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0")) {
            QLog.e(TAG, 1, "g()  uin is error, uin = " + str);
        }
        if (sAccountInstance == null) {
            synchronized (TianShuMMKVUtil.class) {
                if (sAccountInstance == null) {
                    sAccountInstance = new TianShuMMKVUtil(QMMKV.from(RFWApplication.getApplication(), QMMKVFile.FILE_TIAN_SHU), new KeyDelegate() { // from class: cooperation.vip.tianshu.a
                        @Override // cooperation.vip.tianshu.TianShuMMKVUtil.KeyDelegate
                        public final String getKey(String str2) {
                            String lambda$g$0;
                            lambda$g$0 = TianShuMMKVUtil.lambda$g$0(str, str2);
                            return lambda$g$0;
                        }
                    });
                }
            }
        }
        return sAccountInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$g$0(String str, String str2) {
        return str2 + "_" + str;
    }

    public boolean getBoolean(String str, boolean z16) {
        return this.mEntity.decodeBool(this.mDelegate.getKey(str), z16);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        return this.mEntity.decodeBytes(this.mDelegate.getKey(str), bArr);
    }

    public float getFloat(String str, float f16) {
        return this.mEntity.decodeFloat(this.mDelegate.getKey(str), f16);
    }

    public int getInt(String str, int i3) {
        return this.mEntity.decodeInt(this.mDelegate.getKey(str), i3);
    }

    public long getLong(String str, long j3) {
        return this.mEntity.decodeLong(this.mDelegate.getKey(str), j3);
    }

    public <T extends Parcelable> T getParcelable(String str, Class<T> cls, T t16) {
        return (T) this.mEntity.decodeParcelable(this.mDelegate.getKey(str), cls, t16);
    }

    public String getString(String str, @Nullable String str2) {
        return this.mEntity.decodeString(this.mDelegate.getKey(str), str2);
    }

    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return this.mEntity.decodeStringSet(this.mDelegate.getKey(str), set);
    }

    public TianShuMMKVUtil putBoolean(String str, boolean z16) {
        this.mEntity.encodeBool(this.mDelegate.getKey(str), z16);
        return this;
    }

    public TianShuMMKVUtil putBytes(String str, byte[] bArr) {
        this.mEntity.encodeBytes(this.mDelegate.getKey(str), bArr);
        return this;
    }

    public TianShuMMKVUtil putFloat(String str, float f16) {
        this.mEntity.encodeFloat(this.mDelegate.getKey(str), f16);
        return this;
    }

    public TianShuMMKVUtil putInt(String str, int i3) {
        this.mEntity.encodeInt(this.mDelegate.getKey(str), i3);
        return this;
    }

    public TianShuMMKVUtil putLong(String str, long j3) {
        this.mEntity.encodeLong(this.mDelegate.getKey(str), j3);
        return this;
    }

    public TianShuMMKVUtil putParcelable(String str, Parcelable parcelable) {
        this.mEntity.encodeParcelable(this.mDelegate.getKey(str), parcelable);
        return this;
    }

    public TianShuMMKVUtil putString(String str, @Nullable String str2) {
        this.mEntity.encodeString(this.mDelegate.getKey(str), str2);
        return this;
    }

    public TianShuMMKVUtil putStringSet(String str, @Nullable Set<String> set) {
        this.mEntity.encodeStringSet(this.mDelegate.getKey(str), set);
        return this;
    }

    public TianShuMMKVUtil removeKey(String str) {
        this.mEntity.removeKey(this.mDelegate.getKey(str));
        return this;
    }
}
