package com.tencent.qqnt.emotion.pic.libra;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.libra.download.ILibraDownloader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/g;", "Lcom/tencent/libra/download/ILibraDownloader;", "Lcom/tencent/libra/request/Option;", "option", "", "canDownload", "Lcom/tencent/libra/download/ILibraDownloader$PicDownLoadListener;", "loadListener", "", "downLoad", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g implements ILibraDownloader {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final g f356335d = new g();

    g() {
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public boolean canDownload(@NotNull Option option) {
        Integer num;
        Intrinsics.checkNotNullParameter(option, "option");
        Object obj = option.getExtraData().get("extraKeyEmoType");
        Integer num2 = null;
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            Object obj2 = option.getExtraData().get("extraKeyEmoId");
            if (obj2 instanceof Integer) {
                num2 = (Integer) obj2;
            }
            if (num2 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public /* synthetic */ void cancel(Option option) {
        com.tencent.libra.download.a.a(this, option);
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public void downLoad(@NotNull Option option, @Nullable ILibraDownloader.PicDownLoadListener loadListener) {
        Intrinsics.checkNotNullParameter(option, "option");
        Object obj = option.getExtraData().get("extraKeyEmoType");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = option.getExtraData().get("extraKeyEmoId");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) obj2).intValue();
        Object obj3 = option.getExtraData().get("extraKeyPicType");
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
        int intValue3 = ((Integer) obj3).intValue();
        if (QLog.isDevelopLevel()) {
            QLog.d("SysFaceAndEmojiLibraDownloader", 4, "[download] emoType=" + intValue + ", emoId=" + intValue2 + ", picType=" + intValue3);
        }
        Pair<String, Boolean> sysFaceFullResPath = QQSysAndEmojiResMgr.getInstance().getSysFaceFullResPath(intValue3, QQSysFaceUtil.convertToServer(intValue2));
        Intrinsics.checkNotNullExpressionValue(sysFaceFullResPath, "getInstance().getSysFace\u2026esPath(picType, serverId)");
        if (!TextUtils.isEmpty((CharSequence) sysFaceFullResPath.first)) {
            option.setLocalPath((String) sysFaceFullResPath.first);
            if (loadListener != null) {
                loadListener.onResult(true, 0);
            }
        } else if (loadListener != null) {
            loadListener.onResult(false, -1);
        }
        if (QQSysFaceSwitcher.f204652a.n()) {
            if (!QQSysFaceUtil.isStaticFace(intValue2) && !((Boolean) sysFaceFullResPath.second).booleanValue()) {
                QQSysAndEmojiResMgr.getInstance().getResImpl(intValue).addReloadDrawable(intValue2);
                QLog.d("SysFaceAndEmojiLibraDownloader", 1, "[download] missing dynamic face, emoId=" + intValue2);
                return;
            }
            if (QQSysFaceUtil.isStaticFace(intValue2) && TextUtils.isEmpty((CharSequence) sysFaceFullResPath.first)) {
                QQSysAndEmojiResMgr.getInstance().getResImpl(intValue).addReloadDrawable(intValue2);
                QLog.d("SysFaceAndEmojiLibraDownloader", 1, "[download] missing static face, emoId=" + intValue2);
            }
        }
    }

    @Override // com.tencent.libra.download.ILibraDownloader
    public /* synthetic */ boolean needDownloadOnWorkThread() {
        return com.tencent.libra.download.a.b(this);
    }
}
