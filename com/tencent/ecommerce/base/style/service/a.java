package com.tencent.ecommerce.base.style.service;

import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.pts.utils.b;
import com.tencent.pts.utils.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/style/service/a;", "Lcom/tencent/pts/utils/a;", "", "b", "", "token", "", "getColor", "Landroid/graphics/drawable/Drawable;", "getDrawable", "Lcom/tencent/pts/utils/b;", "ptsResourceCallback", "a", "Ljava/lang/String;", "tag", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a implements com.tencent.pts.utils.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f100995b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String tag = "ECPtsResourceManager";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/base/style/service/a$a", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.style.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static final class C1034a implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f100996d;

        C1034a(b bVar) {
            this.f100996d = bVar;
        }

        public void a(Drawable drawable) {
            b bVar = this.f100996d;
            if (bVar != null) {
                bVar.a(drawable);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    a() {
    }

    public final void b() {
        c.d(this);
    }

    @Override // com.tencent.pts.utils.a
    public Drawable getDrawable(String token) {
        ECSkin eCSkin = ECSkin.INSTANCE;
        if (token == null) {
            token = "";
        }
        return eCSkin.getDrawable(token);
    }

    @Override // com.tencent.pts.utils.a
    public void a(String token, b ptsResourceCallback) {
        if (token == null || token.length() == 0) {
            cg0.a.a(tag, "getDrawable", "token is nullOrEmpty.");
        } else {
            IECCoreSkinApi.a.a(ECSkin.INSTANCE, token, null, new C1034a(ptsResourceCallback), 2, null);
        }
    }

    @Override // com.tencent.pts.utils.a
    public int getColor(String token) {
        Integer color;
        if ((token == null || token.length() == 0) || (color = ECSkin.INSTANCE.getColor(token)) == null) {
            return 0;
        }
        return color.intValue();
    }
}
