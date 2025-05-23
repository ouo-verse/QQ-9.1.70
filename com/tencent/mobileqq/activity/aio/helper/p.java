package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u00172\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u0006\u0010\u0010\u001a\u00020\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/p;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/aio/title/ae;", "d", "", "iconUrl", "name", "Lkotlin/Function0;", "", "onClickCallback", "c", "e", "", "a", "Z", "hasReportExposure", "<init>", "()V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportExposure;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J*\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/p$b", "Lcom/tencent/mobileqq/aio/title/ac;", "", "d", "", "c", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "defaultIconDrawable", "Lkotlin/Pair;", "", "b", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "iconUrl", "iconDrawable", "", "f", "e", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.aio.title.ac {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f178858a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p f178859b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f178860c;

        b(String str, p pVar, Function0<Unit> function0) {
            this.f178858a = str;
            this.f178859b = pVar;
            this.f178860c = function0;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void a() {
            com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_lucky_identifier");
            Function0<Unit> function0 = this.f178860c;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        @NotNull
        public Pair<String, Drawable> b(@Nullable Context context, @NotNull Drawable defaultIconDrawable) {
            Intrinsics.checkNotNullParameter(defaultIconDrawable, "defaultIconDrawable");
            return new Pair<>(this.f178858a, defaultIconDrawable);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public boolean c() {
            return true;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public float d() {
            return 1.0f;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void e() {
            if (!this.f178859b.hasReportExposure) {
                this.f178859b.hasReportExposure = true;
                com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_lucky_identifier");
            }
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void f(@Nullable Resources resources, @NotNull ImageView view, @NotNull String iconUrl, @NotNull Drawable iconDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
            com.tencent.mobileqq.mutualmark.alienation.f.m(resources, view, iconUrl, iconDrawable);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.aio.title.ae c(@NotNull String iconUrl, @NotNull String name, @Nullable Function0<Unit> onClickCallback) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        return new com.tencent.mobileqq.aio.title.ae(iconUrl, 0, name, new b(iconUrl, this, onClickCallback));
    }

    @NotNull
    public abstract Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> d(@NotNull Activity activity, @NotNull TroopInfo troopInfo);

    public final void e() {
        this.hasReportExposure = false;
    }
}
