package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.af;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.HashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile k f182349b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, com.tencent.mobileqq.activity.framebusiness.controllerinject.a> f182350a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final int f182351d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<FrameFragment> f182352e;

        public a(FrameFragment frameFragment, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, frameFragment, Integer.valueOf(i3));
            } else {
                this.f182351d = i3;
                this.f182352e = new WeakReference<>(frameFragment);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                FrameFragment frameFragment = this.f182352e.get();
                if (frameFragment == null) {
                    QLog.d("FrameUtil.TabControlHelper", 1, "[tabClick] current frag is null, do nothing, tabIndex=" + this.f182351d);
                } else {
                    frameFragment.mTabIndicator.setCurrentTab(this.f182351d);
                    View a16 = frameFragment.mTabHost.a();
                    if (a16 != null) {
                        a16.requestFocus(2);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<String, com.tencent.mobileqq.activity.framebusiness.controllerinject.a> hashMap = new HashMap<>();
        this.f182350a = hashMap;
        hashMap.put(TabDataHelper.TAB_CONVERSATION, new c());
        this.f182350a.put("GUILD", new d());
        this.f182350a.put(TabDataHelper.TAB_NEW_WORLD, new h());
        this.f182350a.put(TabDataHelper.TAB_CONTACT, new b());
        this.f182350a.put(TabDataHelper.TAB_RIJ, new i());
        this.f182350a.put(TabDataHelper.TAB_LEBA, new f());
        this.f182350a.put(TabDataHelper.TAB_META_DREAM, new g());
    }

    private int a(FrameFragment frameFragment, @Nullable Pair<Integer, String> pair) {
        if (pair == null) {
            return -1;
        }
        int intValue = ((Integer) pair.first).intValue();
        String str = (String) pair.second;
        if (intValue > 0 && intValue < frameFragment.mTabHostTabListWithOrder.size() && !TextUtils.isEmpty(str)) {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tab_layout_opt_9070_124851941", true)) {
                int size = frameFragment.mTabHostTabListWithOrder.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (str.equals(frameFragment.mTabHostTabListWithOrder.get(i3).getTag())) {
                        QLog.i("FrameUtil.TabControlHelper", 1, "considerSetLastTab, lastTag:" + str + ", oldIndex:" + intValue + ", newIndex=" + i3);
                        return i3;
                    }
                }
            }
            String tag = frameFragment.mTabHostTabListWithOrder.get(intValue).getTag();
            if (!str.equals(tag)) {
                QLog.i("FrameUtil.TabControlHelper", 1, "tag not equals, lastTag:" + str + " targetTag:" + tag);
                return -1;
            }
            QLog.i("FrameUtil.TabControlHelper", 1, "setCurrentTab lastIndex:" + intValue + ", lastTag:" + str);
            return intValue;
        }
        QLog.i("FrameUtil.TabControlHelper", 1, "param is invalid, lastIndex:" + intValue + ", size:" + frameFragment.mTabHostTabListWithOrder.size() + ", lastTag:" + str);
        return -1;
    }

    public static k b() {
        if (f182349b == null) {
            synchronized (k.class) {
                if (f182349b == null) {
                    f182349b = new k();
                }
            }
        }
        return f182349b;
    }

    public com.tencent.mobileqq.activity.framebusiness.controllerinject.a c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.activity.framebusiness.controllerinject.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.f182350a.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
    
        if (r10 == (-1)) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(FrameFragment frameFragment, @Nullable Pair<Integer, String> pair, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, frameFragment, pair, Integer.valueOf(i3));
            return;
        }
        if (frameFragment != null && frameFragment.mTabHost != null && frameFragment.mTabIndicator != null && frameFragment.mTabHostTabList != null && frameFragment.getContext() != null && frameFragment.getQBaseActivity() != null && frameFragment.mTabHostTabListWithOrder != null) {
            int modelType = TabDataHelper.getModelType();
            String[] transferConfigStringToArray = TabDataHelper.transferConfigStringToArray(TabDataHelper.getTabRuleList(frameFragment.getContext(), frameFragment.getQBaseActivity().getCurrentAccountUinFromRuntime(), modelType));
            for (String str : transferConfigStringToArray) {
                com.tencent.mobileqq.activity.framebusiness.controllerinject.a c16 = b().c(str);
                if (c16 != null) {
                    int i17 = 0;
                    while (true) {
                        if (i17 >= frameFragment.mTabHostTabList.size()) {
                            break;
                        }
                        FrameFragment.e eVar = frameFragment.mTabHostTabList.get(i17);
                        if (eVar != null && c16.a(eVar.getTag())) {
                            frameFragment.mTabHost.c(eVar);
                            frameFragment.mTabHostTabListWithOrder.add(eVar);
                            if (af.d()) {
                                eVar.a().setOnClickListener(new a(frameFragment, frameFragment.mTabHostTabListWithOrder.size() - 1));
                            }
                        } else {
                            i17++;
                        }
                    }
                }
            }
            if (af.d()) {
                if (!GuildInjectImpl.K(frameFragment.getContext()) && !GuildInjectImpl.M(frameFragment.getContext())) {
                    i16 = a(frameFragment, pair);
                } else {
                    ((FrameHelperActivity) frameFragment).sj();
                    String name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
                    for (int i18 = 0; i18 < frameFragment.mTabHostTabListWithOrder.size(); i18++) {
                        if (name.equals(frameFragment.mTabHostTabListWithOrder.get(i18).getTag())) {
                            i16 = i18;
                            break;
                        }
                    }
                    i16 = 0;
                    frameFragment.mTabHost.b(i16);
                    if (i16 == 0) {
                        frameFragment.createTabContent(Conversation.class.getName(), false);
                    }
                }
            } else {
                int a16 = a(frameFragment, pair);
                if (a16 != -1) {
                    frameFragment.mTabIndicator.setCurrentTab(a16);
                }
            }
            StringBuilder sb5 = new StringBuilder("handleTabByConfig");
            sb5.append(" currentMode: ");
            sb5.append(modelType);
            sb5.append(", configArray: ");
            sb5.append(Arrays.toString(transferConfigStringToArray));
            sb5.append(", toAddList: ");
            sb5.append(af.e(frameFragment.mTabHostTabList));
            sb5.append(", realAddList: ");
            sb5.append(af.e(frameFragment.mTabHostTabListWithOrder));
            QLog.d("FrameUtil.TabControlHelper", 1, sb5);
        }
    }
}
