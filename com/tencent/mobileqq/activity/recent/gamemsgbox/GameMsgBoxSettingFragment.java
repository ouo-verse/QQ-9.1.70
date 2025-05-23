package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgNoticeSettingPart;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$GameDetail;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgMgrSvr$SwitchInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GameMsgBoxSettingFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;
    private Intent C;
    private AppRuntime D;
    private HashMap<String, GameSwitchConfig> E;
    private List<GameMsgMgrSvr$GameDetail> F;
    private final HashMap<String, Integer> G;
    private GameMsgNoticeSettingPart H;
    private QUISettingsRecyclerView I;
    private QUIListItemAdapter J;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f185435a;

        /* renamed from: b, reason: collision with root package name */
        public String f185436b;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public GameMsgBoxSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = new HashMap<>();
            this.G = new HashMap<>();
        }
    }

    private GameMsgMgrSvr$GameDetail Ah(String str) {
        for (GameMsgMgrSvr$GameDetail gameMsgMgrSvr$GameDetail : this.F) {
            if (str.equals(gameMsgMgrSvr$GameDetail.appid.get())) {
                return gameMsgMgrSvr$GameDetail;
            }
        }
        return null;
    }

    private void Bh() {
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth);
        this.J = qUIListItemAdapter;
        qUIListItemAdapter.t0(zh());
        this.I.setHasTopSpace(false);
        this.I.setDividerStyle(QUISettingsRecyclerView.DividerStyle.Hidden);
        this.I.setAdapter(this.J);
    }

    private void Ch() {
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "");
        for (GameMsgMgrSvr$GameDetail gameMsgMgrSvr$GameDetail : this.F) {
            if (wh(gameMsgMgrSvr$GameDetail)) {
                String str = gameMsgMgrSvr$GameDetail.appid.get();
                GameSwitchConfig findGameSwitchConfig = iGameMsgManagerService.findGameSwitchConfig(str);
                if (findGameSwitchConfig == null) {
                    findGameSwitchConfig = yh(str, gameMsgMgrSvr$GameDetail.switch_info.get());
                }
                this.E.put(str, findGameSwitchConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Dh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
        activityURIRequest.extra().putString("url", "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-guide?_wv=2&_wwv=134");
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
        activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Eh(LinearLayout linearLayout, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String optString = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMCENTER_MSG_PARTNER_CONFIG).optString("partnerSettingUrl");
        if (TextUtils.isEmpty(optString)) {
            QLog.e("IphoneTitleBarFragment", 1, "partnerSettingUrl is empty");
        } else {
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(linearLayout.getContext(), optString);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Fh(ImageView imageView, String str) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
            obtain.mLoadingDrawable = defaultFaceDrawable;
            obtain.mFailedDrawable = defaultFaceDrawable;
            imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        } catch (Exception e16) {
            QLog.e("IphoneTitleBarFragment", 1, "load avatar parse uin fail" + e16);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(String str, View view) {
        int intValue;
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer num = this.G.get(str);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.H.P9(intValue, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(int i3, int i16, String str) {
        String str2;
        GameSwitchConfig gameSwitchConfig = this.E.get(str);
        IGameMsgBoxRuntimeService iGameMsgBoxRuntimeService = (IGameMsgBoxRuntimeService) this.D.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
        com.tencent.mobileqq.gamecenter.data.c cVar = new com.tencent.mobileqq.gamecenter.data.c();
        if (i16 != -1 && i16 != i3) {
            try {
                if (i16 == 0) {
                    gameSwitchConfig.mSyncSwitch = 1;
                    gameSwitchConfig.mBlockSwitch = 0;
                    gameSwitchConfig.mMuteSwitch = 0;
                    cVar.a("mutext_switch_type", 0);
                    iGameMsgBoxRuntimeService.setShouldShowNewUnAuthorizedSummary(false, getContext());
                } else if (i16 == 1) {
                    gameSwitchConfig.mSyncSwitch = 1;
                    gameSwitchConfig.mBlockSwitch = 0;
                    gameSwitchConfig.mMuteSwitch = 1;
                    cVar.a("mutext_switch_type", 1);
                    iGameMsgBoxRuntimeService.setShouldShowNewUnAuthorizedSummary(false, getContext());
                } else if (i16 == 2) {
                    gameSwitchConfig.mSyncSwitch = 0;
                    gameSwitchConfig.mBlockSwitch = 0;
                    gameSwitchConfig.mMuteSwitch = 0;
                    cVar.a("mutext_switch_type", 0);
                } else if (i16 == 3) {
                    gameSwitchConfig.mBlockSwitch = 1;
                    gameSwitchConfig.mSyncSwitch = 0;
                    gameSwitchConfig.mMuteSwitch = 0;
                    cVar.a("mutext_switch_type", 0);
                }
                IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) this.D.getRuntimeService(IGameMsgManagerService.class, "");
                GameMsgMgrSvr$GameDetail Ah = Ah(gameSwitchConfig.mAppId);
                if (Ah == null || Ah.name.get() == null) {
                    str2 = "";
                } else {
                    str2 = Ah.name.get();
                }
                ((IGameMsgBoxManager) this.D.getRuntimeService(IGameMsgBoxManager.class, "")).setConfigToNTKernel(this.D, gameSwitchConfig, str2, true);
                this.J.t0(zh());
                this.G.put(str, Integer.valueOf(i16));
                Object[] array = this.E.values().toArray();
                ArrayList<GameSwitchConfig> arrayList = new ArrayList<>();
                for (Object obj : array) {
                    arrayList.add((GameSwitchConfig) obj);
                }
                iGameMsgManagerService.saveOrUpdateGameSwitchConfigs(arrayList);
                ((IGameMsgUnissoHandlerApi) QRoute.api(IGameMsgUnissoHandlerApi.class)).setGameSwitch(this.C.getIntExtra("hashCode", 0), str, gameSwitchConfig.mSyncSwitch, gameSwitchConfig.mBlockSwitch, cVar);
            } catch (NullPointerException e16) {
                QLog.e("IphoneTitleBarFragment", 1, "onActivityResult fail, exception:" + e16.getMessage(), e16);
            }
        }
    }

    private void uh(LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        this.I = new QUISettingsRecyclerView(requireContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = ViewUtils.dpToPx(20.0f);
        linearLayout.addView(this.I, layoutParams);
    }

    private void vh(final LinearLayout linearLayout) {
        if (linearLayout == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ViewUtils.dip2px(20.0f);
        LinearLayout linearLayout2 = new LinearLayout(requireContext());
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(linearLayout.getContext().getColor(R.color.qui_common_fill_light_primary));
        linearLayout.addView(linearLayout2, layoutParams);
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(getResources().getText(R.string.f199454pg)), new x.c.g("", true, false));
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(requireContext());
        qUISingleLineListItem.setConfig(xVar);
        qUISingleLineListItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ah
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameMsgBoxSettingFragment.this.Dh(view);
            }
        });
        linearLayout2.addView(qUISingleLineListItem);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        View view = new View(requireContext());
        view.setBackgroundColor(linearLayout.getContext().getColor(R.color.qui_common_border_standard));
        int dpToPx = ViewUtils.dpToPx(16.0f);
        layoutParams2.rightMargin = dpToPx;
        layoutParams2.leftMargin = dpToPx;
        linearLayout2.addView(view, layoutParams2);
        com.tencent.mobileqq.widget.listitem.x<x.b, x.c> xVar2 = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(getResources().getText(R.string.f199414pc)), new x.c.g("", true, false));
        QUISingleLineListItem qUISingleLineListItem2 = new QUISingleLineListItem(requireContext());
        qUISingleLineListItem2.setConfig(xVar2);
        qUISingleLineListItem2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameMsgBoxSettingFragment.Eh(linearLayout, view2);
            }
        });
        linearLayout2.addView(qUISingleLineListItem2);
    }

    private boolean wh(GameMsgMgrSvr$GameDetail gameMsgMgrSvr$GameDetail) {
        if (gameMsgMgrSvr$GameDetail != null && !TextUtils.isEmpty(gameMsgMgrSvr$GameDetail.appid.get()) && !TextUtils.isEmpty(gameMsgMgrSvr$GameDetail.name.get()) && !TextUtils.isEmpty(gameMsgMgrSvr$GameDetail.icon.get())) {
            return true;
        }
        return false;
    }

    private a xh(GameSwitchConfig gameSwitchConfig) {
        a aVar = new a();
        aVar.f185435a = 0;
        aVar.f185436b = getResources().getText(R.string.f199474pi).toString();
        if (gameSwitchConfig == null) {
            return aVar;
        }
        int i3 = gameSwitchConfig.mSyncSwitch;
        if (i3 == 1) {
            if (gameSwitchConfig.mMuteSwitch == 1) {
                aVar.f185435a = 1;
                aVar.f185436b = getResources().getText(R.string.f199484pj).toString();
            } else {
                aVar.f185436b = getResources().getText(R.string.f199474pi).toString();
            }
        } else if (i3 == 0) {
            aVar.f185435a = 2;
            aVar.f185436b = getResources().getText(R.string.f199464ph).toString();
        }
        if (gameSwitchConfig.mBlockSwitch == 1) {
            aVar.f185435a = 3;
            aVar.f185436b = getResources().getText(R.string.f199274oz).toString();
        }
        return aVar;
    }

    private GameSwitchConfig yh(String str, GameMsgMgrSvr$SwitchInfo gameMsgMgrSvr$SwitchInfo) {
        GameSwitchConfig gameSwitchConfig = new GameSwitchConfig();
        gameSwitchConfig.mAppId = str;
        gameSwitchConfig.mSyncSwitch = gameMsgMgrSvr$SwitchInfo.sync_switch.get();
        gameSwitchConfig.mMuteSwitch = gameMsgMgrSvr$SwitchInfo.mutex_switch.get();
        gameSwitchConfig.mBlockSwitch = gameMsgMgrSvr$SwitchInfo.qq_block_switch.get();
        return gameSwitchConfig;
    }

    private Group[] zh() {
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<GameMsgMgrSvr$GameDetail> it = this.F.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            GameMsgMgrSvr$GameDetail next = it.next();
            if (wh(next)) {
                final String str = next.appid.get();
                String str2 = next.name.get();
                String str3 = next.icon.get();
                a xh5 = xh(this.E.get(str));
                this.G.put(str, Integer.valueOf(xh5.f185435a));
                com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.c(str2, str3), new x.c.g(xh5.f185436b, true, false));
                xVar.T(new Function2() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.aj
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit Fh;
                        Fh = GameMsgBoxSettingFragment.Fh((ImageView) obj, (String) obj2);
                        return Fh;
                    }
                });
                xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ak
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GameMsgBoxSettingFragment.this.Gh(str, view);
                    }
                });
                arrayList2.add(xVar);
            }
        }
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[arrayList2.size()];
        for (i3 = 0; i3 < arrayList2.size(); i3++) {
            aVarArr[i3] = (com.tencent.mobileqq.widget.listitem.a) arrayList2.get(i3);
        }
        arrayList.add(new Group(aVarArr));
        return (Group[]) arrayList.toArray(new Group[arrayList.size()]);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        GameMsgNoticeSettingPart gameMsgNoticeSettingPart = new GameMsgNoticeSettingPart();
        this.H = gameMsgNoticeSettingPart;
        gameMsgNoticeSettingPart.O9(new GameMsgNoticeSettingPart.b() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ag
            @Override // com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgNoticeSettingPart.b
            public final void a(int i3, int i16, String str) {
                GameMsgBoxSettingFragment.this.Hh(i3, i16, str);
            }
        });
        arrayList.add(this.H);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, layoutInflater, viewGroup, bundle);
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (!(view instanceof LinearLayout)) {
            onFinish();
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        setTitle(getResources().getString(R.string.f199354p7));
        vh(linearLayout);
        uh(linearLayout);
        Bh();
        this.leftView.setContentDescription(getString(R.string.f170549u3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.eau;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @androidx.annotation.Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 != 0 && intent != null) {
            Hh(intent.getIntExtra(com.tencent.luggage.wxa.c8.c.G, -2), intent.getIntExtra("new_option", -1), intent.getStringExtra("appid"));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        this.D = getQBaseActivity().getAppRuntime();
        this.C = getActivity().getIntent();
        this.F = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameListOfMsgBox();
        Ch();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onFinish();
        }
    }
}
