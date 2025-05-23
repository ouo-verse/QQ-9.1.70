package oe;

import android.content.Intent;
import com.qzone.reborn.feedpro.utils.ao;
import com.qzone.reborn.share.QQShareActionManagerV2;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Loe/q;", "Lcom/qzone/reborn/share/a;", "Lre/b;", "r", "Lcom/qzone/reborn/share/e;", "shareContext", "", "i", "", "", "g", "Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/utils/q;", "c", "Lcom/qzone/reborn/feedpro/utils/q;", "getForwardClickProcess", "()Lcom/qzone/reborn/feedpro/utils/q;", "setForwardClickProcess", "(Lcom/qzone/reborn/feedpro/utils/q;)V", "forwardClickProcess", "<init>", "()V", "d", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class q extends com.qzone.reborn.share.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.utils.q forwardClickProcess;

    private final re.b r() {
        com.qzone.reborn.share.i viewModel = getViewModel();
        if (viewModel instanceof re.b) {
            return (re.b) viewModel;
        }
        return null;
    }

    @Override // com.qzone.reborn.share.a
    public void b(com.qzone.reborn.share.e shareContext, com.qzone.reborn.share.b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.forwardClickProcess == null) {
            this.forwardClickProcess = new com.qzone.reborn.feedpro.utils.q();
        }
        com.qzone.reborn.feedpro.utils.q qVar = this.forwardClickProcess;
        if (qVar != null) {
            qVar.c(shareContext);
        }
    }

    @Override // com.qzone.reborn.share.a
    public QQShareActionManagerV2.ShareLine f() {
        return QQShareActionManagerV2.ShareLine.FIRST;
    }

    @Override // com.qzone.reborn.share.a
    public List<String> g() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("qzoneshuoshuo");
        return arrayListOf;
    }

    @Override // com.qzone.reborn.share.a
    public boolean i(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        ao aoVar = ao.f54312a;
        return !aoVar.d(r() != null ? r0.S1() : null, 14);
    }

    @Override // com.qzone.reborn.share.a
    public void l(int requestCode, int resultCode, Intent data) {
        super.l(requestCode, resultCode, data);
        if (requestCode != 1206) {
            return;
        }
        if (resultCode != -1) {
            QLog.e("QzoneFeedProDetailShareToQzoneAction", 1, "onActivityResult error:" + resultCode);
            return;
        }
        com.qzone.reborn.feedpro.utils.q qVar = this.forwardClickProcess;
        if (qVar != null) {
            qVar.b(data);
        }
    }

    @Override // com.qzone.reborn.share.a
    public void m(com.qzone.reborn.share.e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QLog.i("QzoneFeedProDetailShareToQzoneAction", 2, "onDisableClick clicked");
        ao aoVar = ao.f54312a;
        re.b r16 = r();
        aoVar.q(r16 != null ? r16.S1() : null, "qzoneshuoshuo");
    }
}
