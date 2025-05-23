package com.tencent.biz.pubaccount.weishi.profile.header;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import h00.j;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J4\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/WSProfileHeaderUtils;", "", "", "url", "Landroid/graphics/drawable/ColorDrawable;", "drawable", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "imageView", "", "a", "Landroid/content/Context;", "context", "LUserGrowth/stSchema;", "jumpScheme", "from", "LUserGrowth/stSimpleMetaPerson;", "personInfo", "position", "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSProfileHeaderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final WSProfileHeaderUtils f81291a = new WSProfileHeaderUtils();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/profile/header/WSProfileHeaderUtils$a", "Lh00/d;", "", "d", "a", "c", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81292a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81293b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaPerson f81294c;

        a(String str, String str2, stSimpleMetaPerson stsimplemetaperson) {
            this.f81292a = str;
            this.f81293b = str2;
            this.f81294c = stsimplemetaperson;
        }

        @Override // h00.d, h00.b
        public void a() {
            super.a();
            String str = this.f81292a;
            String str2 = this.f81293b;
            stSimpleMetaPerson stsimplemetaperson = this.f81294c;
            com.tencent.biz.pubaccount.weishi.profile.b.p(str, str2, stsimplemetaperson != null ? stsimplemetaperson.f25130id : null, 1000004);
        }

        @Override // h00.d, h00.b
        public void c() {
            super.c();
            String str = this.f81292a;
            String str2 = this.f81293b;
            stSimpleMetaPerson stsimplemetaperson = this.f81294c;
            com.tencent.biz.pubaccount.weishi.profile.b.p(str, str2, stsimplemetaperson != null ? stsimplemetaperson.f25130id : null, 1000007);
        }

        @Override // h00.d, h00.b
        public void d() {
            super.d();
            String str = this.f81292a;
            String str2 = this.f81293b;
            stSimpleMetaPerson stsimplemetaperson = this.f81294c;
            com.tencent.biz.pubaccount.weishi.profile.b.p(str, str2, stsimplemetaperson != null ? stsimplemetaperson.f25130id : null, 1000003);
        }
    }

    WSProfileHeaderUtils() {
    }

    public final void b(Context context, stSchema jumpScheme, String from, stSimpleMetaPerson personInfo, String position) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(position, "position");
        new j(context).l(true).k(true).o(jumpScheme).m(new a(from, position, personInfo)).h();
    }

    @JvmStatic
    public static final void a(String url, ColorDrawable drawable, KandianUrlImageView imageView) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        WeakReference weakReference = new WeakReference(imageView);
        WeakReference weakReference2 = new WeakReference(drawable);
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "WSProfileHeaderView.loadCover", null, null, null, new WSProfileHeaderUtils$loadCover$1(weakReference, url, width, height, weakReference2, null), 14, null);
        }
    }
}
