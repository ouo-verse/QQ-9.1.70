package com.tencent.qqnt.qbasealbum;

import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import com.tencent.qqnt.qbasealbum.preview.fragment.QAlbumPreviewMainFragment;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class WinkHomeActivity$onCreate$1 extends Lambda implements Function1<PreviewInitBean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ WinkHomeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkHomeActivity$onCreate$1(WinkHomeActivity winkHomeActivity) {
        super(1);
        this.this$0 = winkHomeActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) winkHomeActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final PreviewInitBean it, WinkHomeActivity this$0) {
        ImageView imageView;
        List listOf;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ArrayList<LocalMediaInfo> a16 = it.a();
        try {
            boolean z16 = true;
            if (!a16.isEmpty()) {
                int size = a16.size();
                int c16 = it.c();
                if (c16 < 0 || c16 >= size) {
                    z16 = false;
                }
                if (z16) {
                    RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
                    FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    a aVar = a.f360732a;
                    WeakReference<ImageView> c17 = aVar.c();
                    if (c17 != null) {
                        imageView = c17.get();
                    } else {
                        imageView = null;
                    }
                    LocalMediaInfo localMediaInfo = a16.get(it.c());
                    Intrinsics.checkNotNullExpressionValue(localMediaInfo, "allMedia[it.previewPos]");
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(com.tencent.qqnt.qbasealbum.ktx.b.u(localMediaInfo));
                    com.tencent.qqnt.qbasealbum.base.model.e.b(rFWLayerLaunchUtil, this$0, supportFragmentManager, imageView, listOf, 0, QAlbumPreviewMainFragment.class, null, R.id.cks);
                    aVar.m(null);
                }
            }
        } catch (IndexOutOfBoundsException e16) {
            ox3.a.f("WinkHomeActivity", new Function0<String>(a16, it, e16) { // from class: com.tencent.qqnt.qbasealbum.WinkHomeActivity$onCreate$1$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<LocalMediaInfo> $allMedia;
                final /* synthetic */ IndexOutOfBoundsException $e;
                final /* synthetic */ PreviewInitBean $it;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$allMedia = a16;
                    this.$it = it;
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, a16, it, e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "getFirstFragment size: " + this.$allMedia.size() + " pos: " + this.$it.c() + " e: " + this.$e;
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PreviewInitBean previewInitBean) {
        invoke2(previewInitBean);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final PreviewInitBean it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        final WinkHomeActivity winkHomeActivity = this.this$0;
        winkHomeActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.e
            @Override // java.lang.Runnable
            public final void run() {
                WinkHomeActivity$onCreate$1.b(PreviewInitBean.this, winkHomeActivity);
            }
        });
    }
}
