package com.tencent.qqperf.safemode;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes25.dex */
public class SafeModeTestQQMCClearConfigProcessor extends BaseConfigParser<a> {

    /* loaded from: classes25.dex */
    public static class a implements IConfigData {

        /* renamed from: d, reason: collision with root package name */
        String f363379d;

        a(String str) {
            this.f363379d = str;
        }

        public String toString() {
            String obj = super.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj);
            sb5.append(" ");
            String str = this.f363379d;
            if (str == null) {
                str = "NULL";
            }
            sb5.append(str);
            return sb5.toString();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a("");
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        try {
            String str = new String(bArr);
            QLog.d("SafeModeTestQQMCClearConfigProcessor", 1, "parse: \n" + str);
            return new a(str);
        } catch (Throwable th5) {
            try {
                QLog.e("SafeModeTestQQMCClearConfigProcessor", 1, "parse failed!", th5);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean z16) {
        super.onReceive(z16);
        QLog.w("SafeModeTestQQMCClearConfigProcessor", 1, "onReceive");
    }
}
