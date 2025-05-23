package com.tencent.mobileqq.guild.gift.impl.module;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.gift.impl.module.c;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.gift.module.l;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lo1.GiftListDataConfig;
import lo1.GuildGiftConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sh2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/impl/module/c;", "Lcom/tencent/mobileqq/guild/gift/module/a;", "Lcom/tencent/mobileqq/guild/gift/module/f;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "B", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lsh2/c;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;", "tab", "d", "", "v", "hide", "", "receiverId", "setReceiver", "(Ljava/lang/Long;)V", "c", "()Ljava/lang/Long;", "j", tl.h.F, "Lsh2/c;", "i", "Ljava/lang/Long;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends com.tencent.mobileqq.guild.gift.module.a implements com.tencent.mobileqq.guild.gift.module.f {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private sh2.c panel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long receiverId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J,\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/gift/impl/module/c$a", "Lcom/tencent/mobileqq/guild/gift/impl/module/k;", "", "f", "t", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "", "position", "O", "isSuccess", "errCode", "", "errMsg", ICustomDataEditor.NUMBER_PARAM_1, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends k {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0, View it) {
            m panelEventListener;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("IGuildGiftEngine.", "notify onPanelShow, panelContentView:" + it.getHeight());
            }
            GuildGiftConfig guildGiftConfig = this$0.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig != null && (panelEventListener = guildGiftConfig.getPanelEventListener()) != null) {
                panelEventListener.of(it);
            }
        }

        @Override // sh2.c.f
        public boolean O(@NotNull com.tencent.mobileqq.qqgift.data.service.d data, int position) {
            com.tencent.mobileqq.qqgift.data.service.c cVar;
            Function0<HashMap<String, String>> p16;
            HashMap<String, String> invoke;
            Function0<HashMap<String, String>> o16;
            HashMap<String, String> invoke2;
            com.tencent.mobileqq.guild.gift.module.e giftDataAdapter;
            com.tencent.mobileqq.guild.gift.module.k<Object> g16;
            Intrinsics.checkNotNullParameter(data, "data");
            if (c.this.receiverId != null) {
                GuildGiftConfig guildGiftConfig = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                if (guildGiftConfig != null && (giftDataAdapter = guildGiftConfig.getGiftDataAdapter()) != null) {
                    int i3 = data.f264874d;
                    Long l3 = c.this.receiverId;
                    Intrinsics.checkNotNull(l3);
                    cVar = giftDataAdapter.b(i3, l3.longValue());
                } else {
                    cVar = null;
                }
                if (cVar == null) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("onSendGiftClick, reqData is null!");
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
                    }
                    return true;
                }
                if (c.this.getSdk() != null) {
                    GuildGiftConfig guildGiftConfig2 = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                    if (guildGiftConfig2 != null && (o16 = guildGiftConfig2.o()) != null && (invoke2 = o16.invoke()) != null) {
                        cVar.f264870k.putAll(invoke2);
                    }
                    GuildGiftConfig guildGiftConfig3 = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                    if (guildGiftConfig3 != null && (p16 = guildGiftConfig3.p()) != null && (invoke = p16.invoke()) != null) {
                        cVar.f264869j.putAll(invoke);
                    }
                    nh2.c sdk = c.this.getSdk();
                    Intrinsics.checkNotNull(sdk);
                    sdk.a().Q(cVar);
                    return false;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("onSendGiftClick, sdk is null!");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it5.next(), null);
                }
                return true;
            }
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("onSendGiftClick, receiver id is null!");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it6.next(), null);
            }
            GuildGiftConfig guildGiftConfig4 = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig4 != null && (g16 = guildGiftConfig4.g()) != null) {
                g16.o();
            }
            return true;
        }

        @Override // sh2.c.f
        public boolean f() {
            final View z16;
            IQQGiftRechargeModule f16;
            HashMap<String, String> hashMap;
            Function0<HashMap<String, String>> l3;
            nh2.c sdk = c.this.getSdk();
            if (sdk != null && (f16 = sdk.f()) != null) {
                GuildGiftConfig guildGiftConfig = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                if (guildGiftConfig != null && (l3 = guildGiftConfig.l()) != null) {
                    hashMap = l3.invoke();
                } else {
                    hashMap = null;
                }
                f16.k(hashMap);
            }
            sh2.c cVar = c.this.panel;
            if (cVar != null && (z16 = cVar.z()) != null) {
                final c cVar2 = c.this;
                z16.post(new Runnable() { // from class: com.tencent.mobileqq.guild.gift.impl.module.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a.b(c.this, z16);
                    }
                });
                return false;
            }
            return false;
        }

        @Override // sh2.c.f
        public boolean n1(boolean isSuccess, @Nullable com.tencent.mobileqq.qqgift.data.service.d data, int errCode, @Nullable String errMsg) {
            Long l3;
            Integer num;
            com.tencent.mobileqq.guild.gift.module.k<Object> g16;
            sh2.c cVar;
            if (isSuccess && data != null) {
                if (data.f264883i == 1 && (cVar = c.this.panel) != null) {
                    cVar.hide();
                }
                c.this.z(data);
                return false;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (data != null) {
                l3 = Long.valueOf(data.K);
            } else {
                l3 = null;
            }
            if (data != null) {
                num = Integer.valueOf(data.f264874d);
            } else {
                num = null;
            }
            String str = "onSendGiftCallback, " + isSuccess + ", receiver:" + l3 + ", giftId:" + num + " errCode:" + errCode + ", errMsg:" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            GuildGiftConfig guildGiftConfig = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig != null && (g16 = guildGiftConfig.g()) != null) {
                g16.s(errCode, errMsg);
            }
            return true;
        }

        @Override // sh2.c.f
        public boolean t() {
            oh2.a b16;
            m panelEventListener;
            GuildGiftConfig guildGiftConfig = c.this.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig != null && (panelEventListener = guildGiftConfig.getPanelEventListener()) != null) {
                panelEventListener.t();
            }
            nh2.c sdk = c.this.getSdk();
            if (sdk != null && (b16 = sdk.b()) != null) {
                b16.reset();
            }
            c.this.panel = null;
            return false;
        }
    }

    private final void A(sh2.c panel) {
        GiftListDataConfig giftListDataConfig;
        String str;
        GuildGiftConfig guildGiftConfig = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (guildGiftConfig != null && (giftListDataConfig = guildGiftConfig.getGiftListDataConfig()) != null) {
            com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a();
            aVar.f264855a = giftListDataConfig.getPanelType();
            Long l3 = this.receiverId;
            if (l3 == null || (str = l3.toString()) == null) {
                str = "";
            }
            aVar.f264858d = str;
            panel.setSceneData(aVar);
        }
    }

    private final void B(FragmentActivity activity) {
        ph2.a d16;
        sh2.c p16;
        c.g tabSelectedListener;
        sh2.c cVar;
        View.OnClickListener emptyPackClickListener;
        sh2.c cVar2;
        com.tencent.mobileqq.qqgift.mvvm.business.data.b panelStyle;
        sh2.c cVar3;
        Function0<HashMap<String, String>> d17;
        com.tencent.mobileqq.qqgift.mvvm.business.data.a aVar;
        HashMap<String, String> hashMap = null;
        if (activity.findViewById(R.id.content).getWindowToken() == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("showPanel err, windowToken is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("IGuildGiftEngine.", 1, (String) it.next(), null);
            }
            return;
        }
        nh2.c sdk = getSdk();
        if (sdk != null && (d16 = sdk.d()) != null && (p16 = d16.p(activity)) != null) {
            this.panel = p16;
            Intrinsics.checkNotNull(p16);
            A(p16);
            sh2.c cVar4 = this.panel;
            Intrinsics.checkNotNull(cVar4);
            y(cVar4);
            a aVar2 = new a();
            sh2.c cVar5 = this.panel;
            if (cVar5 != null) {
                Intrinsics.checkNotNull(cVar5);
                cVar5.setPanelEventListener(cVar5.l(aVar2));
            }
            sh2.c cVar6 = this.panel;
            if (cVar6 != null) {
                GuildGiftConfig guildGiftConfig = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                if (guildGiftConfig != null) {
                    aVar = guildGiftConfig.getGiftDtParams();
                } else {
                    aVar = null;
                }
                cVar6.setDtParams(aVar);
            }
            sh2.c cVar7 = this.panel;
            if (cVar7 != null) {
                GuildGiftConfig guildGiftConfig2 = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                if (guildGiftConfig2 != null && (d17 = guildGiftConfig2.d()) != null) {
                    hashMap = d17.invoke();
                }
                cVar7.setDtPageExtra(hashMap);
            }
            GuildGiftConfig guildGiftConfig3 = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig3 != null && (panelStyle = guildGiftConfig3.getPanelStyle()) != null && (cVar3 = this.panel) != null) {
                cVar3.setPanelStyle(panelStyle);
            }
            GuildGiftConfig guildGiftConfig4 = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig4 != null && (emptyPackClickListener = guildGiftConfig4.getEmptyPackClickListener()) != null && (cVar2 = this.panel) != null) {
                cVar2.setEmptyPackClickListener(emptyPackClickListener);
            }
            GuildGiftConfig guildGiftConfig5 = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig5 != null && (tabSelectedListener = guildGiftConfig5.getTabSelectedListener()) != null && (cVar = this.panel) != null) {
                cVar.setTabSelectedListener(tabSelectedListener);
            }
            sh2.c cVar8 = this.panel;
            if (cVar8 != null) {
                cVar8.p(activity.findViewById(R.id.content));
            }
        }
    }

    private final void y(sh2.c panel) {
        l headViewCreator;
        GuildGiftConfig guildGiftConfig = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (guildGiftConfig != null && (headViewCreator = guildGiftConfig.getHeadViewCreator()) != null) {
            Context a16 = panel.a();
            Intrinsics.checkNotNullExpressionValue(a16, "panel.viewContext");
            ViewGroup contentView = panel.getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView, "panel.contentView");
            View r16 = headViewCreator.r(a16, contentView);
            if (r16 != null) {
                panel.k().addView(r16, new ViewGroup.LayoutParams(-1, -2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(com.tencent.mobileqq.qqgift.data.service.d data) {
        com.tencent.mobileqq.guild.gift.module.e giftDataAdapter;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a c16;
        com.tencent.mobileqq.guild.gift.module.k<Object> g16;
        GuildGiftConfig guildGiftConfig = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        if (guildGiftConfig != null && (giftDataAdapter = guildGiftConfig.getGiftDataAdapter()) != null && (c16 = giftDataAdapter.c(data)) != null) {
            if (giftDataAdapter.a(c16)) {
                com.tencent.mobileqq.guild.gift.module.a.p(this, new com.tencent.mobileqq.guild.gift.impl.module.a(c16), false, 2, null);
            }
            GuildGiftConfig guildGiftConfig2 = getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (guildGiftConfig2 != null && (g16 = guildGiftConfig2.g()) != null) {
                g16.x(c16, data.f264875d0);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.f
    @Nullable
    /* renamed from: c, reason: from getter */
    public Long getReceiverId() {
        return this.receiverId;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.f
    public void d(@NotNull ShowPanelTab tab, @NotNull FragmentActivity activity) {
        sh2.c cVar;
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(activity, "activity");
        B(activity);
        if (tab == ShowPanelTab.Pack && (cVar = this.panel) != null) {
            cVar.setFirstShowGiftTabConfig("PACKAGE_TAB_ID");
        }
    }

    @Override // com.tencent.mobileqq.guild.gift.module.f
    public void hide() {
        sh2.c cVar = this.panel;
        if (cVar != null) {
            cVar.hide();
        }
        this.panel = null;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.a
    public void j() {
        super.j();
        hide();
        this.receiverId = null;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.f
    public void setReceiver(@Nullable Long receiverId) {
        this.receiverId = receiverId;
    }

    @Override // com.tencent.mobileqq.guild.gift.module.f
    public int v() {
        sh2.c cVar = this.panel;
        if (cVar != null) {
            return cVar.y();
        }
        return 0;
    }
}
