package com.tencent.luggage.wxa.l6;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 404;

    @NotNull
    public static final String NAME = "getClipboardData";

    /* renamed from: a, reason: collision with root package name */
    public static final a f133064a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public String ERR_MSG_TAG() {
        return "err_msg";
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.k6.b env, JSONObject jSONObject, int i3) {
        ClipData primaryClip;
        String str;
        Intrinsics.checkNotNullParameter(env, "env");
        HashMap hashMap = new HashMap();
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(z.c(), ClipboardManager.class);
        if (clipboardManager != null && (primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager)) != null && primaryClip.getItemCount() > 0) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            Intrinsics.checkNotNull(itemAt);
            CharSequence text = itemAt.getText();
            if (text != null) {
                str = text.toString();
            } else {
                str = null;
            }
            String str2 = "";
            if (str == null) {
                str = "";
            }
            hashMap.put("data", str);
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                str2 = htmlText;
            }
            hashMap.put("htmlText", str2);
        }
        env.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
