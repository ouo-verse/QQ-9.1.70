package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.TabType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/PictureOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "f", "Landroid/content/Intent;", "result", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "permissionList", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "listener", "d", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "Ljava/util/List;", "mPermissionList", "<init>", "()V", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PictureOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f360476b;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mPermissionList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/PictureOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/pluspanel/processor/PictureOnClickProcessor$b", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends com.tencent.qqnt.aio.shortcutbar.j {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f360479d;

        b(com.tencent.aio.api.runtime.a aVar) {
            this.f360479d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PictureOnClickProcessor.this, (Object) aVar);
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                PictureOnClickProcessor.this.f(this.f360479d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65830);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f360476b = new a(null);
        }
    }

    public PictureOnClickProcessor() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
            this.mPermissionList = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(Activity activity, List<String> permissionList, com.tencent.qqnt.aio.shortcutbar.j listener) {
        Iterator<T> it = permissionList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (activity.checkSelfPermission((String) it.next()) != 0) {
                z16 = true;
            }
        }
        if (!z16) {
            listener.b();
            return;
        }
        com.tencent.mobileqq.aio.shortcurtbar.permission.a aVar = com.tencent.mobileqq.aio.shortcurtbar.permission.a.f193758a;
        Object[] array = permissionList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.a(activity, "album", (String[]) array, 2, listener);
    }

    private final void e(Intent result, com.tencent.aio.api.runtime.a context) {
        AlbumResult albumResult;
        List<LocalMediaInfo> e16;
        if (result != null) {
            albumResult = (AlbumResult) result.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult == null || (e16 = albumResult.e()) == null || !albumResult.b()) {
            return;
        }
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), null, null, new PictureOnClickProcessor$onAlbumResult$1(e16, context, albumResult, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final com.tencent.aio.api.runtime.a context) {
        TabType tabType;
        boolean z16;
        int e16 = context.g().r().c().e();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = context.c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "context.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        boolean z17 = false;
        aVar2.j(false);
        aVar2.g(20);
        if (((IAlbumApi) QRoute.api(IAlbumApi.class)).needToBlockVideo(context.g().r().c().e())) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.h(4);
        aVar2.b(new ArrayList());
        aVar2.e(e16);
        if (e16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.d(z16);
        if (e16 != 8) {
            z17 = true;
        }
        aVar2.m(z17);
        Unit unit = Unit.INSTANCE;
        Intent e17 = com.tencent.qqnt.qbasealbum.a.e(aVar, requireContext, aVar2.a(), null, null, null, 28, null);
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpAlbum(e17, context);
        context.f().a(e17, new ActivityResultCallback() { // from class: com.tencent.qqnt.pluspanel.processor.q
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PictureOnClickProcessor.g(PictureOnClickProcessor.this, context, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PictureOnClickProcessor this$0, com.tencent.aio.api.runtime.a context, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (activityResult.getResultCode() != -1) {
            return;
        }
        this$0.e(activityResult.getData(), context);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(@NotNull com.tencent.qqnt.pluspanel.data.a data, @NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        if (FastClickUtils.isFastDoubleClick("PictureOnClickProcessor")) {
            return;
        }
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        d(requireActivity, this.mPermissionList, new b(context));
    }
}
