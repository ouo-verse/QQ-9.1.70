package com.tencent.mobileqq.hermes.share;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.hermes.easteregg.BrandEasterConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\b\u0010%\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010+\u001a\u00020&\u0012\b\u00101\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b>\u0010?J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010'\u001a\u0004\b\u001f\u0010(\"\u0004\b)\u0010*R$\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010-\u001a\u0004\b\u000f\u0010.\"\u0004\b/\u00100R0\u00108\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0019\u0010=\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "c", "()Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "g", "()Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "shareManger", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "d", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "()Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "layerItemInfo", "Landroid/graphics/Bitmap;", "e", "Landroid/graphics/Bitmap;", "f", "()Landroid/graphics/Bitmap;", tl.h.F, "(Landroid/graphics/Bitmap;)V", "shareBitmap", "", "J", "()J", "setRankingNum", "(J)V", "rankingNum", "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", "()Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", "setEasterConfigBean", "(Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;)V", "easterConfigBean", "Lkotlin/Pair;", "Lkotlin/Pair;", "getMainAndSubId", "()Lkotlin/Pair;", "setMainAndSubId", "(Lkotlin/Pair;)V", "mainAndSubId", "i", "Ljava/lang/String;", "getExistSaveOrEditPath", "()Ljava/lang/String;", "existSaveOrEditPath", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;Landroid/graphics/Bitmap;JLcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;)V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final /* data */ class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HermesShareActionManager shareManger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RFWLayerItemMediaInfo layerItemInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap shareBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long rankingNum;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BrandEasterConfigBean easterConfigBean;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Pair<Long, Integer> mainAndSubId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String existSaveOrEditPath;

    public k(@NotNull Activity activity, @NotNull Fragment fragment, @NotNull HermesShareActionManager shareManger, @NotNull RFWLayerItemMediaInfo layerItemInfo, @Nullable Bitmap bitmap, long j3, @Nullable BrandEasterConfigBean brandEasterConfigBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(layerItemInfo, "layerItemInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, fragment, shareManger, layerItemInfo, bitmap, Long.valueOf(j3), brandEasterConfigBean);
            return;
        }
        this.activity = activity;
        this.fragment = fragment;
        this.shareManger = shareManger;
        this.layerItemInfo = layerItemInfo;
        this.shareBitmap = bitmap;
        this.rankingNum = j3;
        this.easterConfigBean = brandEasterConfigBean;
        String existSaveOrEditPath = layerItemInfo.getExistSaveOrEditPath();
        this.existSaveOrEditPath = existSaveOrEditPath;
        QLog.i("NTShareContext", 1, "mainAndSubId:" + this.mainAndSubId + " existSaveOrEditPath:" + existSaveOrEditPath);
    }

    @NotNull
    public final Activity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @Nullable
    public final BrandEasterConfigBean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BrandEasterConfigBean) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.easterConfigBean;
    }

    @NotNull
    public final Fragment c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fragment;
    }

    @NotNull
    public final RFWLayerItemMediaInfo d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RFWLayerItemMediaInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.layerItemInfo;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.rankingNum;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (Intrinsics.areEqual(this.activity, kVar.activity) && Intrinsics.areEqual(this.fragment, kVar.fragment) && Intrinsics.areEqual(this.shareManger, kVar.shareManger) && Intrinsics.areEqual(this.layerItemInfo, kVar.layerItemInfo) && Intrinsics.areEqual(this.shareBitmap, kVar.shareBitmap) && this.rankingNum == kVar.rankingNum && Intrinsics.areEqual(this.easterConfigBean, kVar.easterConfigBean)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Bitmap f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.shareBitmap;
    }

    @NotNull
    public final HermesShareActionManager g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HermesShareActionManager) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.shareManger;
    }

    public final void h(@Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
        } else {
            this.shareBitmap = bitmap;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.activity.hashCode() * 31) + this.fragment.hashCode()) * 31) + this.shareManger.hashCode()) * 31) + this.layerItemInfo.hashCode()) * 31;
        Bitmap bitmap = this.shareBitmap;
        int i3 = 0;
        if (bitmap == null) {
            hashCode = 0;
        } else {
            hashCode = bitmap.hashCode();
        }
        int a16 = (((hashCode2 + hashCode) * 31) + androidx.fragment.app.a.a(this.rankingNum)) * 31;
        BrandEasterConfigBean brandEasterConfigBean = this.easterConfigBean;
        if (brandEasterConfigBean != null) {
            i3 = brandEasterConfigBean.hashCode();
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "HermesShareContext(activity=" + this.activity + ", fragment=" + this.fragment + ", shareManger=" + this.shareManger + ", layerItemInfo=" + this.layerItemInfo + ", shareBitmap=" + this.shareBitmap + ", rankingNum=" + this.rankingNum + ", easterConfigBean=" + this.easterConfigBean + ")";
    }
}
