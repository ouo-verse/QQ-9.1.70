package com.tencent.mobileqq.sharepanel.config;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.action.j;
import common.config.service.QzoneConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/c;", "", "", "channelId", "Lcom/tencent/mobileqq/sharepanel/action/j;", "a", "", "b", "Ljava/util/Map;", "shareChannelMap", "", "c", "Ljava/util/List;", "shareChannelList", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f287231a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, j> shareChannelMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<j> shareChannelList;

    static {
        List<j> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f287231a = new c();
        shareChannelMap = new LinkedHashMap();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new j("qqfriend", R.drawable.oh9, "QQ\u597d\u53cb"), new j("qzoneshuoshuo", R.drawable.ohd, "\u7a7a\u95f4"), new j("transfertoqzone", R.drawable.ohf, "\u8f6c\u8f7d\u5230\u7a7a\u95f4"), new j("qqchannel", R.drawable.ohh, "\u817e\u8baf\u9891\u9053"), new j("weixin", R.drawable.ohi, "\u5fae\u4fe1\u597d\u53cb"), new j("weixincircle", R.drawable.oh7, "\u670b\u53cb\u5708"), new j("qqbrowser", R.drawable.oh8, "QQ\u6d4f\u89c8\u5668"), new j("browser", R.drawable.f160374oh0, "\u6d4f\u89c8\u5668"), new j(MiniProgramLpReportDC04239.FILE_MATERIAL_SUB_ACTION_MENU, R.drawable.oh6, "\u5c0f\u7a0b\u5e8f\u6253\u5f00"), new j("otherapp", R.drawable.qui_more_feedback_normal, "\u5176\u4ed6\u5e94\u7528"), new j(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, R.drawable.ohe, "\u7a7a\u95f4\u76f8\u518c"), new j("groupalbum", R.drawable.f160377oh3, "\u7fa4\u76f8\u518c"), new j("intimatezone", R.drawable.f160378oh4, QzoneConfig.DEFAULT_VALUE_INTIMATE_SPACE_NAME), new j("mypc", R.drawable.f160375oh1, "\u6211\u7684\u7535\u8111"), new j("weiyun", R.drawable.qui_weiyun_feedback_normal, "\u5fae\u4e91"), new j("redbook", R.drawable.ohk, "\u5c0f\u7ea2\u4e66"));
        shareChannelList = mutableListOf;
        for (j jVar : mutableListOf) {
            jVar.j(b.f287212a.a(jVar.h()));
            shareChannelMap.put(jVar.h(), jVar);
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final j a(@NotNull String channelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
        }
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        j jVar = shareChannelMap.get(channelId);
        if (jVar == null) {
            return null;
        }
        j jVar2 = new j(jVar.h(), jVar.c(), jVar.d());
        jVar2.j(jVar.i());
        return jVar2;
    }
}
