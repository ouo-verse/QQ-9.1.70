package com.tencent.mobileqq.guild.emoj;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.y;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0013B\u0013\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/emoj/e;", "Lcom/tencent/mobileqq/emotionintegrate/y;", "", "path", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "D", ReportConstant.COSTREPORT_PREFIX, "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "B", "Lcom/tencent/mobileqq/data/MessageRecord;", "msg", "<init>", "(Lcom/tencent/mobileqq/data/MessageRecord;)V", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends y {
    public e(MessageRecord messageRecord) {
        super(messageRecord);
    }

    private final boolean C(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    private final Drawable D(Context context) {
        MessageRecord messageRecord = this.f205303a;
        MessageForPic messageForPic = messageRecord instanceof MessageForPic ? (MessageForPic) messageRecord : null;
        if (messageForPic == null || context == null) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        return URLDrawable.getFileDrawable(messageForPic.path, obtain);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.y
    public PicElement B() {
        return null;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.y, com.tencent.mobileqq.emotionintegrate.p
    public Drawable c(Context context) {
        Drawable c16;
        MessageRecord messageRecord = this.f205303a;
        MessageForPic messageForPic = messageRecord instanceof MessageForPic ? (MessageForPic) messageRecord : null;
        String str = messageForPic != null ? messageForPic.path : null;
        if (str == null) {
            str = "";
        }
        boolean exists = new File(str).exists();
        QLog.i("GuildMsgEmoticonPreviewData", 1, "getDrawable isMarketFace=" + r() + " exists=" + exists);
        if (r()) {
            Drawable c17 = super.c(context);
            Intrinsics.checkNotNullExpressionValue(c17, "{\n            super.getDrawable(context)\n        }");
            return c17;
        }
        if (exists) {
            Drawable D = D(context);
            c16 = D == null ? super.c(context) : D;
        } else {
            c16 = super.c(context);
        }
        Intrinsics.checkNotNullExpressionValue(c16, "{\n            if (exists\u2026)\n            }\n        }");
        return c16;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.p
    public boolean q() {
        return true;
    }

    @Override // com.tencent.mobileqq.emotionintegrate.y, com.tencent.mobileqq.emotionintegrate.p
    public boolean s() {
        if (r()) {
            return super.s();
        }
        MessageRecord messageRecord = this.f205303a;
        if (!(messageRecord instanceof MessageForPic)) {
            return false;
        }
        Intrinsics.checkNotNull(messageRecord, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPic");
        String str = ((MessageForPic) messageRecord).path;
        boolean C = C(str);
        QLog.i("GuildMsgEmoticonPreviewData", 1, "checkMsgPicReady picReady=" + C + " sourcePath=" + str);
        return C;
    }
}
