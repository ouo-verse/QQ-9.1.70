package com.tencent.mobileqq.qqlive.widget.chat.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002#\u001cB\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000fH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u0011H\u0002J$\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/b;", "", "Lpq4/c;", "bubbleStyleV2", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "listener", "", tl.h.F, "Landroid/content/Context;", "context", "k", "j", "i", "", "url", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "bgColorFirst", "bgColorSecond", "", "orientation", "Landroid/graphics/drawable/GradientDrawable;", "l", "g", "", "b", UserInfo.SEX_FEMALE, "RADIUS", "c", "MULTI_RADIUS", "<init>", "()V", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f273904a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float RADIUS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final float MULTI_RADIUS;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "rightOffset", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void a(@Nullable Drawable drawable, int rightOffset);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$b;", "", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC8407b {
        void a(@Nullable URLDrawable drawable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$c", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "rightOffset", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<pq4.c> f273907a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f273908b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f273909c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList<Drawable> f273910d;

        c(Ref.ObjectRef<pq4.c> objectRef, Context context, d dVar, ArrayList<Drawable> arrayList) {
            this.f273907a = objectRef;
            this.f273908b = context;
            this.f273909c = dVar;
            this.f273910d = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, objectRef, context, dVar, arrayList);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.a
        public void a(@Nullable Drawable drawable, int rightOffset) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, rightOffset);
                return;
            }
            if (drawable != null) {
                this.f273910d.add(drawable);
            }
            pq4.c cVar = this.f273907a.element;
            if (cVar.f427024b != null) {
                String str = cVar.f427024b.f427016a;
                Intrinsics.checkNotNullExpressionValue(str, "bubbleInfo.bgImage.imageUrl");
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    pq4.c cVar2 = this.f273907a.element;
                    if (1 == cVar2.f427024b.f427017b) {
                        b.f273904a.k(this.f273908b, cVar2, this.f273909c);
                        return;
                    } else {
                        if (cVar2.f427024b.f427017b == 0) {
                            b.f273904a.j(this.f273908b, cVar2, this.f273909c);
                            return;
                        }
                        return;
                    }
                }
            }
            this.f273909c.a(null, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$d", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "rightOffset", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<pq4.c> f273911a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f273912b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList<Drawable> f273913c;

        d(Ref.ObjectRef<pq4.c> objectRef, e eVar, ArrayList<Drawable> arrayList) {
            this.f273911a = objectRef;
            this.f273912b = eVar;
            this.f273913c = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, objectRef, eVar, arrayList);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.a
        public void a(@Nullable Drawable drawable, int rightOffset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, rightOffset);
                return;
            }
            if (drawable != null) {
                this.f273913c.add(drawable);
            }
            b.f273904a.i(this.f273911a.element, this.f273912b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$e", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$a;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "rightOffset", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<Integer> f273914a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<Drawable> f273915b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f273916c;

        e(ArrayList<Integer> arrayList, ArrayList<Drawable> arrayList2, a aVar) {
            this.f273914a = arrayList;
            this.f273915b = arrayList2;
            this.f273916c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, arrayList, arrayList2, aVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.a
        public void a(@Nullable Drawable drawable, int rightOffset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable, rightOffset);
                return;
            }
            if (drawable != null) {
                this.f273915b.add(drawable);
            }
            this.f273914a.add(Integer.valueOf(rightOffset));
            if (this.f273915b.size() > 0) {
                Iterator<Integer> it = this.f273914a.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    Integer offset = it.next();
                    Intrinsics.checkNotNullExpressionValue(offset, "offset");
                    if (offset.intValue() > i3) {
                        i3 = offset.intValue();
                    }
                }
                Object[] array = this.f273915b.toArray(new Drawable[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.f273916c.a(new LayerDrawable((Drawable[]) array), i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$f", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$b;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements InterfaceC8407b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f273917a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pq4.d f273918b;

        f(a aVar, pq4.d dVar) {
            this.f273917a = aVar;
            this.f273918b = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.InterfaceC8407b
        public void a(@Nullable URLDrawable urlDrawable) {
            boolean isBlank;
            float f16;
            boolean isBlank2;
            float f17;
            boolean isBlank3;
            float f18;
            boolean isBlank4;
            float f19;
            boolean isBlank5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlDrawable);
                return;
            }
            int i3 = 0;
            if (urlDrawable != null) {
                Bitmap n3 = b.f273904a.n(urlDrawable);
                if (n3.getWidth() != 0 && n3.getHeight() != 0) {
                    pq4.d dVar = this.f273918b;
                    if (dVar.f427031c != 0 && dVar.f427032d != 0) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(wi2.c.c(this.f273918b.f427031c) / n3.getWidth(), wi2.c.c(this.f273918b.f427032d) / n3.getHeight());
                        Bitmap createBitmap = Bitmap.createBitmap(n3, 0, 0, n3.getWidth(), n3.getHeight(), matrix, true);
                        if (!createBitmap.isMutable()) {
                            createBitmap = createBitmap.copy(Bitmap.Config.ARGB_8888, true);
                            AegisLogger.INSTANCE.e("Chat_Message|MsgBubbleRenderUtil", "buildDecorationBitmapDrawable", "Copy to create bitmap.");
                        }
                        Bitmap bitmap = createBitmap;
                        String str = this.f273918b.f427034f;
                        Intrinsics.checkNotNullExpressionValue(str, "image.leftOffset");
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank) {
                            String str2 = this.f273918b.f427034f;
                            Intrinsics.checkNotNullExpressionValue(str2, "image.leftOffset");
                            f16 = wi2.c.c(Float.parseFloat(str2));
                        } else {
                            f16 = 0.0f;
                        }
                        String str3 = this.f273918b.f427036h;
                        Intrinsics.checkNotNullExpressionValue(str3, "image.rightOffset");
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
                        if (!isBlank2) {
                            String str4 = this.f273918b.f427036h;
                            Intrinsics.checkNotNullExpressionValue(str4, "image.rightOffset");
                            f17 = wi2.c.c(Float.parseFloat(str4));
                        } else {
                            f17 = 0.0f;
                        }
                        String str5 = this.f273918b.f427033e;
                        Intrinsics.checkNotNullExpressionValue(str5, "image.topOffset");
                        isBlank3 = StringsKt__StringsJVMKt.isBlank(str5);
                        if (!isBlank3) {
                            String str6 = this.f273918b.f427033e;
                            Intrinsics.checkNotNullExpressionValue(str6, "image.topOffset");
                            f18 = wi2.c.c(Float.parseFloat(str6));
                        } else {
                            f18 = 0.0f;
                        }
                        String str7 = this.f273918b.f427035g;
                        Intrinsics.checkNotNullExpressionValue(str7, "image.bottomOffset");
                        isBlank4 = StringsKt__StringsJVMKt.isBlank(str7);
                        if (!isBlank4) {
                            String str8 = this.f273918b.f427035g;
                            Intrinsics.checkNotNullExpressionValue(str8, "image.bottomOffset");
                            f19 = wi2.c.c(Float.parseFloat(str8));
                        } else {
                            f19 = 0.0f;
                        }
                        String str9 = this.f273918b.f427037i;
                        Intrinsics.checkNotNullExpressionValue(str9, "image.rightSafe");
                        isBlank5 = StringsKt__StringsJVMKt.isBlank(str9);
                        if (!isBlank5) {
                            String str10 = this.f273918b.f427037i;
                            Intrinsics.checkNotNullExpressionValue(str10, "image.rightSafe");
                            i3 = wi2.c.a(wi2.c.c(Float.parseFloat(str10)));
                        }
                        this.f273917a.a(new com.tencent.mobileqq.qqlive.widget.chat.util.drawable.a(bitmap, this.f273918b.f427030b, f16, f17, f18, f19), i3);
                        return;
                    }
                }
                this.f273917a.a(null, 0);
                return;
            }
            this.f273917a.a(null, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$g", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$b;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class g implements InterfaceC8407b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f273919a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ pq4.c f273920b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f273921c;

        g(a aVar, pq4.c cVar, Context context) {
            this.f273919a = aVar;
            this.f273920b = cVar;
            this.f273921c = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, cVar, context);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.InterfaceC8407b
        public void a(@Nullable URLDrawable drawable) {
            byte[] byteArray;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            if (drawable == null) {
                this.f273919a.a(null, 0);
                return;
            }
            try {
                b bVar = b.f273904a;
                Drawable currDrawable = drawable.getCurrDrawable();
                Intrinsics.checkNotNullExpressionValue(currDrawable, "drawable.currDrawable");
                Bitmap n3 = bVar.n(currDrawable);
                n3.setDensity(480);
                int[] iArr = this.f273920b.f427024b.f427022g;
                Intrinsics.checkNotNullExpressionValue(iArr, "bubbleStyleV2.bgImage.ninePatchChunk");
                ArrayList arrayList = new ArrayList(iArr.length);
                for (int i3 : iArr) {
                    arrayList.add(Byte.valueOf((byte) i3));
                }
                byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
                this.f273919a.a(new NinePatchDrawable(this.f273921c.getResources(), n3, byteArray, new Rect(), ""), 0);
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Chat_Message|MsgBubbleRenderUtil", "buildNinePatchBitmapDrawable", "exception={" + e16 + '}');
                this.f273919a.a(null, 0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$h", "Lcom/tencent/mobileqq/qqlive/widget/chat/util/b$b;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class h implements InterfaceC8407b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f273922a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f273923b;

        h(a aVar, Context context) {
            this.f273922a = aVar;
            this.f273923b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.util.b.InterfaceC8407b
        public void a(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            if (drawable == null) {
                this.f273922a.a(null, 0);
                return;
            }
            b bVar = b.f273904a;
            Drawable currDrawable = drawable.getCurrDrawable();
            Intrinsics.checkNotNullExpressionValue(currDrawable, "drawable.currDrawable");
            Bitmap n3 = bVar.n(currDrawable);
            n3.setDensity(480);
            Resources resources = this.f273923b.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            com.tencent.mobileqq.qqlive.widget.chat.util.drawable.c cVar = new com.tencent.mobileqq.qqlive.widget.chat.util.drawable.c(resources, n3, b.RADIUS, b.MULTI_RADIUS);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            cVar.setTileModeXY(tileMode, tileMode);
            cVar.setDither(true);
            cVar.setAntiAlias(true);
            this.f273922a.a(cVar, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/util/b$i", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "t", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class i implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f273924d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC8407b f273925e;

        i(String str, InterfaceC8407b interfaceC8407b) {
            this.f273924d = str;
            this.f273925e = interfaceC8407b;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) interfaceC8407b);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) urlDrawable);
                return;
            }
            AegisLogger.INSTANCE.i("Chat_Message|MsgBubbleRenderUtil", "downloadUrlDrawable", "load canceled,url=" + this.f273924d);
            this.f273925e.a(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable urlDrawable, @Nullable Throwable t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) urlDrawable, (Object) t16);
                return;
            }
            AegisLogger.INSTANCE.i("Chat_Message|MsgBubbleRenderUtil", "downloadUrlDrawable", "load failed,url=" + this.f273924d);
            this.f273925e.a(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable urlDrawable, int t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) urlDrawable, t16);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable urlDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) urlDrawable);
                return;
            }
            AegisLogger.INSTANCE.i("Chat_Message|MsgBubbleRenderUtil", "downloadUrlDrawable", "load success,url=" + this.f273924d);
            this.f273925e.a(urlDrawable);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f273904a = new b();
        RADIUS = ht3.a.a("qqlive_message_bubble_radius", wi2.c.d(20));
        MULTI_RADIUS = ht3.a.a("qqlive_multi_message_bubble_radius", wi2.c.d(12));
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:12:0x0024, B:14:0x0028, B:16:0x002f, B:17:0x0040, B:20:0x0057, B:22:0x0076, B:26:0x0091, B:28:0x00a4, B:30:0x00aa, B:37:0x00b8, B:39:0x00bc, B:41:0x00c0, B:44:0x00c9, B:46:0x00cc, B:48:0x00dd, B:50:0x00fc, B:52:0x0114, B:54:0x0127, B:59:0x0134, B:61:0x0142, B:62:0x0153, B:64:0x0159, B:66:0x0160, B:68:0x0180, B:73:0x016b, B:80:0x003a), top: B:11:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(pq4.c bubbleStyleV2, a listener) {
        boolean z16;
        int ordinal;
        int i3;
        int[] intArray;
        float[] floatArray;
        boolean z17;
        pq4.e eVar;
        int i16;
        int[] iArr;
        float[] fArr;
        float f16;
        String[] strArr;
        boolean z18;
        int[] intArray2;
        float[] floatArray2;
        boolean z19;
        boolean isBlank;
        float f17;
        int ordinal2;
        boolean z26;
        boolean z27;
        pq4.a aVar = bubbleStyleV2.f427023a;
        if (aVar != null) {
            String[] strArr2 = aVar.f427011a;
            if (strArr2 != null) {
                if (strArr2.length == 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (!z27) {
                    z16 = false;
                    if (!z16) {
                        try {
                            int i17 = aVar.f427015e;
                            if (i17 >= 0 && i17 < GradientDrawable.Orientation.values().length) {
                                ordinal = GradientDrawable.Orientation.values()[i17].ordinal();
                            } else {
                                ordinal = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
                            }
                            i3 = ordinal;
                            String[] strArr3 = bubbleStyleV2.f427023a.f427011a;
                            Intrinsics.checkNotNullExpressionValue(strArr3, "bubbleStyleV2.bgColor.color");
                            ArrayList arrayList = new ArrayList(strArr3.length);
                            for (String str : strArr3) {
                                arrayList.add(Integer.valueOf(Color.parseColor('#' + str)));
                            }
                            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
                            String[] strArr4 = bubbleStyleV2.f427023a.f427012b;
                            Intrinsics.checkNotNullExpressionValue(strArr4, "bubbleStyleV2.bgColor.locations");
                            ArrayList arrayList2 = new ArrayList(strArr4.length);
                            for (String it : strArr4) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList2.add(Float.valueOf(Float.parseFloat(it)));
                            }
                            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList2);
                        } catch (Exception e16) {
                            AegisLogger.INSTANCE.e("Chat_Message|MsgBubbleRenderUtil", "buildColorsDrawable", "exception=" + e16);
                        }
                        if (floatArray != null) {
                            if (floatArray.length == 0) {
                                z26 = true;
                            } else {
                                z26 = false;
                            }
                            if (z26) {
                                z17 = true;
                                if (z17) {
                                    floatArray = null;
                                }
                                eVar = bubbleStyleV2.f427025c;
                                if (eVar != null && (strArr = eVar.f427038a) != null) {
                                    Intrinsics.checkNotNullExpressionValue(strArr, "bubbleStyleV2.stroke.color");
                                    if (strArr.length != 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (!z18) {
                                        String[] strArr5 = bubbleStyleV2.f427025c.f427038a;
                                        Intrinsics.checkNotNullExpressionValue(strArr5, "bubbleStyleV2.stroke.color");
                                        ArrayList arrayList3 = new ArrayList(strArr5.length);
                                        for (String str2 : strArr5) {
                                            arrayList3.add(Integer.valueOf(Color.parseColor('#' + str2)));
                                        }
                                        intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList3);
                                        String[] strArr6 = bubbleStyleV2.f427025c.f427039b;
                                        Intrinsics.checkNotNullExpressionValue(strArr6, "bubbleStyleV2.stroke.locations");
                                        ArrayList arrayList4 = new ArrayList(strArr6.length);
                                        for (String it5 : strArr6) {
                                            Intrinsics.checkNotNullExpressionValue(it5, "it");
                                            arrayList4.add(Float.valueOf(Float.parseFloat(it5)));
                                        }
                                        floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList4);
                                        if (floatArray2.length == 0) {
                                            z19 = true;
                                        } else {
                                            z19 = false;
                                        }
                                        if (z19) {
                                            floatArray2 = null;
                                        }
                                        String str3 = bubbleStyleV2.f427025c.f427040c;
                                        Intrinsics.checkNotNullExpressionValue(str3, "bubbleStyleV2.stroke.borderWidth");
                                        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                                        if (!isBlank) {
                                            String str4 = bubbleStyleV2.f427025c.f427040c;
                                            Intrinsics.checkNotNullExpressionValue(str4, "bubbleStyleV2.stroke.borderWidth");
                                            f17 = wi2.c.c(Float.parseFloat(str4));
                                        } else {
                                            f17 = 0.0f;
                                        }
                                        int i18 = bubbleStyleV2.f427025c.f427043f;
                                        if (i18 >= 0 && i18 < GradientDrawable.Orientation.values().length) {
                                            ordinal2 = GradientDrawable.Orientation.values()[i18].ordinal();
                                        } else {
                                            ordinal2 = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
                                        }
                                        i16 = ordinal2;
                                        iArr = intArray2;
                                        fArr = floatArray2;
                                        f16 = f17;
                                        listener.a(new com.tencent.mobileqq.qqlive.widget.chat.util.drawable.b(RADIUS, MULTI_RADIUS, intArray, floatArray, i3, iArr, fArr, i16, f16), 0);
                                        listener.a(null, 0);
                                        return;
                                    }
                                }
                                i16 = 0;
                                iArr = null;
                                fArr = null;
                                f16 = 0.0f;
                                listener.a(new com.tencent.mobileqq.qqlive.widget.chat.util.drawable.b(RADIUS, MULTI_RADIUS, intArray, floatArray, i3, iArr, fArr, i16, f16), 0);
                                listener.a(null, 0);
                                return;
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                        eVar = bubbleStyleV2.f427025c;
                        if (eVar != null) {
                            Intrinsics.checkNotNullExpressionValue(strArr, "bubbleStyleV2.stroke.color");
                            if (strArr.length != 0) {
                            }
                            if (!z18) {
                            }
                        }
                        i16 = 0;
                        iArr = null;
                        fArr = null;
                        f16 = 0.0f;
                        listener.a(new com.tencent.mobileqq.qqlive.widget.chat.util.drawable.b(RADIUS, MULTI_RADIUS, intArray, floatArray, i3, iArr, fArr, i16, f16), 0);
                        listener.a(null, 0);
                        return;
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        listener.a(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(pq4.c bubbleStyleV2, a listener) {
        boolean z16;
        pq4.d[] dVarArr = bubbleStyleV2.f427026d;
        boolean z17 = true;
        if (dVarArr != null) {
            if (dVarArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            listener.a(null, 0);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(dVarArr, "bubbleStyleV2.decorationImage");
        for (pq4.d dVar : dVarArr) {
            String str = dVar.f427029a;
            Intrinsics.checkNotNullExpressionValue(str, "image.imageUrl");
            m(str, new f(listener, dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Context context, pq4.c bubbleStyleV2, a listener) {
        String str = bubbleStyleV2.f427024b.f427016a;
        Intrinsics.checkNotNullExpressionValue(str, "bubbleStyleV2.bgImage.imageUrl");
        m(str, new g(listener, bubbleStyleV2, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Context context, pq4.c bubbleStyleV2, a listener) {
        String str = bubbleStyleV2.f427024b.f427016a;
        Intrinsics.checkNotNullExpressionValue(str, "bubbleStyleV2.bgImage.imageUrl");
        m(str, new h(listener, context));
    }

    private final void m(String url, InterfaceC8407b listener) {
        if (!HttpUtil.isValidUrl(url)) {
            listener.a(null);
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
        if (drawable.getStatus() == 1) {
            listener.a(drawable);
        } else {
            drawable.setURLDrawableListener(new i(url, listener));
            drawable.startDownload(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap n(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "this.bitmap");
            return bitmap;
        }
        if (drawable instanceof RegionDrawable) {
            Bitmap bitmap2 = ((RegionDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap2, "this.bitmap");
            return bitmap2;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap3);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap3, "bitmap");
        return bitmap3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(@NotNull Context context, @Nullable pq4.c bubbleStyleV2, @NotNull a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, bubbleStyleV2, listener);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (bubbleStyleV2 == 0) {
            return;
        }
        objectRef.element = bubbleStyleV2;
        ArrayList arrayList = new ArrayList();
        h((pq4.c) objectRef.element, new c(objectRef, context, new d(objectRef, new e(new ArrayList(), arrayList, listener), arrayList), arrayList));
    }

    @Nullable
    public final GradientDrawable l(@Nullable String bgColorFirst, @Nullable String bgColorSecond, int orientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GradientDrawable) iPatchRedirector.redirect((short) 2, this, bgColorFirst, bgColorSecond, Integer.valueOf(orientation));
        }
        if (!TextUtils.isEmpty(bgColorFirst) && !TextUtils.isEmpty(bgColorSecond)) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            try {
                float f16 = RADIUS;
                wi2.d.c(gradientDrawable, f16, f16, f16, f16);
                gradientDrawable.setColors(new int[]{Color.parseColor(bgColorFirst), Color.parseColor(bgColorSecond)});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                if (orientation >= 0 && orientation < GradientDrawable.Orientation.values().length) {
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.values()[orientation]);
                }
                gradientDrawable.setGradientType(0);
                return gradientDrawable;
            } catch (IllegalArgumentException e16) {
                QLog.e("Chat_Message|MsgBubbleRenderUtil", 1, "getGradientDrawable" + e16.getMessage());
            }
        }
        return null;
    }
}
