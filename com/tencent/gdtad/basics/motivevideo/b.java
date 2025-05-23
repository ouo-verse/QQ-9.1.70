package com.tencent.gdtad.basics.motivevideo;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/gdtad/basics/motivevideo/b;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "d", "c", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "model", "", "slot", "", "e", "", RewardDialogContentViewHolder.Key.REWARD_TIME, "", "b", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f108898a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GdtMotiveVideoModel model, int i3, WeakReference weakReference) {
        String str;
        Intrinsics.checkNotNullParameter(model, "$model");
        com.tencent.gdtad.basics.motivevideo.report.b bVar = new com.tencent.gdtad.basics.motivevideo.report.b();
        GdtAd gdtAd = model.getGdtAd();
        if (gdtAd != null) {
            str = gdtAd.getUrlForImpression();
        } else {
            str = null;
        }
        String e16 = bVar.e(str);
        if (i3 > 0) {
            e16 = e16 + "&slot=" + i3;
        }
        GdtReporter.doExposeCgiReport(e16);
    }

    @Nullable
    public final String b(@Nullable GdtAd gdtAd, long rewardTime) {
        String str;
        String str2 = null;
        if (gdtAd != null) {
            str = gdtAd.getCustomRewardText();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str != null) {
            try {
                str2 = StringsKt__StringsJVMKt.replace$default(str, "__TIME__", String.valueOf(rewardTime), false, 4, (Object) null);
            } catch (Throwable th5) {
                GdtLog.e("GdtMotiveAdUtils", "[getCustomRewardText]", th5);
                return str;
            }
        }
        return str2;
    }

    public final boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("gdtmv_volume_default_mute", false);
    }

    public final boolean d(@Nullable GdtAd gdtAd) {
        if (gdtAd != null) {
            return gdtAd.isExperiment(122439, "1");
        }
        return false;
    }

    public final void e(@NotNull Context context, @NotNull final GdtMotiveVideoModel model, final int slot) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.getGdtAd() == null) {
            return;
        }
        AdExposureChecker.onClick(context, model.getGdtAd(), new WeakReference(new AdExposureChecker.ExposureCallback() { // from class: com.tencent.gdtad.basics.motivevideo.a
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                b.f(GdtMotiveVideoModel.this, slot, weakReference);
            }
        }));
    }
}
