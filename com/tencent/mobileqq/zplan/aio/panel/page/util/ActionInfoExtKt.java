package com.tencent.mobileqq.zplan.aio.panel.page.util;

import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionType;
import com.tencent.mobileqq.zplan.model.ZPlanEmo2DInfo;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonSizeConfig;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$ActionInfo;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$Emo2DExtraInfo;
import com.tencent.trpcprotocol.zplan.GetZPlanAction$Rectangle;
import com.tencent.zplan.meme.action.MODE;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ku4.b;
import ku4.h;
import ku4.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002\"\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u001b\u0010\u0013\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lku4/b;", "", "extraJson", "Lcom/tencent/mobileqq/zplan/model/e;", "d", "Lcom/tencent/trpcprotocol/zplan/GetZPlanAction$ActionInfo;", "c", "e", "info", "", "f", "Lcom/tencent/sqshow/utils/featureswitch/model/u;", "a", "Lkotlin/Lazy;", "b", "()Lcom/tencent/sqshow/utils/featureswitch/model/u;", "sizeConfig", "", "()Z", "enableEmoticon2DGif", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ActionInfoExtKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f331275a;

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f331276b;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanEmoticonSizeConfig>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.util.ActionInfoExtKt$sizeConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanEmoticonSizeConfig invoke() {
                return ZPlanQQMC.INSTANCE.getZPlanEmoticonSizeConfig();
            }
        });
        f331275a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.util.ActionInfoExtKt$enableEmoticon2DGif$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanFeatureSwitch.f369852a.u());
            }
        });
        f331276b = lazy2;
    }

    private static final boolean a() {
        return ((Boolean) f331276b.getValue()).booleanValue();
    }

    private static final ZPlanEmoticonSizeConfig b() {
        return (ZPlanEmoticonSizeConfig) f331275a.getValue();
    }

    @Deprecated(message = "\u7edf\u4e00\u4f7f\u7528com.tencent.mobileqq.zplan.aio.panel.page.util.ActionInfoExtKt.toZPlanActionInfo2")
    public static final ZPlanActionInfo d(b bVar, String str) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        GetZPlanAction$ActionInfo getZPlanAction$ActionInfo = new GetZPlanAction$ActionInfo();
        getZPlanAction$ActionInfo.f381671id.set(bVar.f413070a);
        getZPlanAction$ActionInfo.name.set(bVar.f413071b);
        getZPlanAction$ActionInfo.type.set(bVar.f413072c);
        getZPlanAction$ActionInfo.icon_url.set(bVar.f413073d);
        getZPlanAction$ActionInfo.player_number.set(bVar.f413074e);
        getZPlanAction$ActionInfo.duration.set(bVar.f413075f);
        getZPlanAction$ActionInfo.intimate_mutual_type.set(bVar.f413076g);
        getZPlanAction$ActionInfo.intimate_mutual_level.set(bVar.f413077h);
        getZPlanAction$ActionInfo.timestamp.set(bVar.f413078i);
        getZPlanAction$ActionInfo.cover_index.set(bVar.f413079j);
        getZPlanAction$ActionInfo.is_dynamic.set(bVar.f413080k);
        getZPlanAction$ActionInfo.min_version.set(bVar.f413081l);
        getZPlanAction$ActionInfo.scale_ratio.set(bVar.f413082m);
        getZPlanAction$ActionInfo.male_default_url.set(bVar.f413083n);
        getZPlanAction$ActionInfo.female_default_url.set(bVar.f413084o);
        if (bVar.f413085p != null) {
            GetZPlanAction$Rectangle getZPlanAction$Rectangle = new GetZPlanAction$Rectangle();
            getZPlanAction$ActionInfo.rec_info = getZPlanAction$Rectangle;
            getZPlanAction$Rectangle.width.set(bVar.f413085p.f413117a);
            getZPlanAction$ActionInfo.rec_info.height.set(bVar.f413085p.f413118b);
        }
        if (bVar.f413086q != null) {
            getZPlanAction$ActionInfo.emo_2d_info.set(new GetZPlanAction$Emo2DExtraInfo());
            getZPlanAction$ActionInfo.emo_2d_info.male_zip_url.set(bVar.f413086q.f413107a);
            getZPlanAction$ActionInfo.emo_2d_info.female_zip_url.set(bVar.f413086q.f413108b);
            getZPlanAction$ActionInfo.emo_2d_info.frame_rate.set(bVar.f413086q.f413109c);
        }
        return c(getZPlanAction$ActionInfo, str);
    }

    private static final ZPlanActionInfo c(GetZPlanAction$ActionInfo getZPlanAction$ActionInfo, String str) {
        ZPlanActionType zPlanActionType;
        ZPlanEmo2DInfo zPlanEmo2DInfo;
        MODE mode;
        int i3 = getZPlanAction$ActionInfo.type.get();
        if (i3 != 1 && i3 != 100) {
            zPlanActionType = ZPlanActionType.ACTION;
        } else {
            zPlanActionType = ZPlanActionType.MEME;
        }
        ZPlanActionType zPlanActionType2 = zPlanActionType;
        if (getZPlanAction$ActionInfo.emo_2d_info.has()) {
            zPlanEmo2DInfo = new ZPlanEmo2DInfo(getZPlanAction$ActionInfo.emo_2d_info.male_zip_url.get(), getZPlanAction$ActionInfo.emo_2d_info.female_zip_url.get(), getZPlanAction$ActionInfo.emo_2d_info.frame_rate.get());
        } else {
            zPlanEmo2DInfo = new ZPlanEmo2DInfo(null, null, 0, 7, null);
        }
        ZPlanEmo2DInfo zPlanEmo2DInfo2 = zPlanEmo2DInfo;
        if (i3 == 100 && a()) {
            mode = MODE.GIF;
        } else {
            mode = MODE.SHARPP;
        }
        int i16 = getZPlanAction$ActionInfo.f381671id.get();
        String str2 = getZPlanAction$ActionInfo.name.get();
        String str3 = getZPlanAction$ActionInfo.icon_url.get();
        int i17 = getZPlanAction$ActionInfo.player_number.get();
        int i18 = getZPlanAction$ActionInfo.duration.get();
        int i19 = getZPlanAction$ActionInfo.intimate_mutual_type.get();
        int i26 = getZPlanAction$ActionInfo.intimate_mutual_level.get();
        ZPlanActionInfo zPlanActionInfo = new ZPlanActionInfo(i16, str2, i3, zPlanActionType2, str3, i17, i18, getZPlanAction$ActionInfo.male_default_url.get(), getZPlanAction$ActionInfo.female_default_url.get(), i19, i26, b().getRecordWidth(), b().getRecordHeight(), zPlanEmo2DInfo2, null, mode, b().getEncodeWidth(), b().getEncodeHeight(), 0, 0, str, null, 2899968, null);
        zPlanActionInfo.I(getZPlanAction$ActionInfo.timestamp.get());
        if (getZPlanAction$ActionInfo.rec_info.has() && getZPlanAction$ActionInfo.rec_info.width.has()) {
            zPlanActionInfo.J(getZPlanAction$ActionInfo.rec_info.width.get());
        }
        if (getZPlanAction$ActionInfo.rec_info.has() && getZPlanAction$ActionInfo.rec_info.height.has()) {
            zPlanActionInfo.w(getZPlanAction$ActionInfo.rec_info.height.get());
        }
        f(zPlanActionInfo);
        return zPlanActionInfo;
    }

    public static final ZPlanActionInfo e(b bVar, String str) {
        ZPlanActionType zPlanActionType;
        ZPlanEmo2DInfo zPlanEmo2DInfo;
        MODE mode;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i3 = bVar.f413072c;
        if (i3 != 1 && i3 != 100) {
            zPlanActionType = ZPlanActionType.ACTION;
        } else {
            zPlanActionType = ZPlanActionType.MEME;
        }
        ZPlanActionType zPlanActionType2 = zPlanActionType;
        h hVar = bVar.f413086q;
        if (hVar != null) {
            zPlanEmo2DInfo = new ZPlanEmo2DInfo(hVar.f413107a, hVar.f413108b, hVar.f413109c);
        } else {
            zPlanEmo2DInfo = new ZPlanEmo2DInfo(null, null, 0, 7, null);
        }
        if (bVar.f413072c == 100 && a()) {
            mode = MODE.GIF;
        } else {
            mode = MODE.SHARPP;
        }
        ZPlanActionInfo zPlanActionInfo = new ZPlanActionInfo(bVar.f413070a, bVar.f413071b, bVar.f413072c, zPlanActionType2, bVar.f413073d, bVar.f413074e, bVar.f413075f, bVar.f413083n, bVar.f413084o, bVar.f413076g, bVar.f413077h, b().getRecordWidth(), b().getRecordHeight(), zPlanEmo2DInfo, null, mode, b().getEncodeWidth(), b().getEncodeHeight(), 0, 0, str, bVar.f413087r, 802816, null);
        zPlanActionInfo.I(bVar.f413078i);
        m mVar = bVar.f413085p;
        if (mVar != null) {
            Integer valueOf = Integer.valueOf(mVar.f413117a);
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                zPlanActionInfo.J(valueOf.intValue());
            }
        }
        m mVar2 = bVar.f413085p;
        if (mVar2 != null) {
            Integer valueOf2 = Integer.valueOf(mVar2.f413118b);
            Integer num = valueOf2.intValue() > 0 ? valueOf2 : null;
            if (num != null) {
                zPlanActionInfo.w(num.intValue());
            }
        }
        f(zPlanActionInfo);
        return zPlanActionInfo;
    }

    private static final void f(ZPlanActionInfo zPlanActionInfo) {
    }
}
