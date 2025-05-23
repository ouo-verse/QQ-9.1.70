package com.tencent.mobileqq.qqvideoedit.zplan.export;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
final class VideoEditTextGifExportTask$dialog$2 extends Lambda implements Function0<QQCustomDialog> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditTextGifExportTask$dialog$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QQCustomDialog invoke() {
        return DialogUtil.createCustomDialog(this.$context, 0, (String) null, "\u8868\u60c5\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", R.string.f171151ok, R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.export.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoEditTextGifExportTask$dialog$2.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
    }
}
