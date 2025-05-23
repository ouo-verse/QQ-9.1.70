package com.tencent.mobileqq.qqlive.room.multichat.report.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.more.d;
import java.util.concurrent.ConcurrentHashMap;
import mm4.b;
import ug4.a;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatReporterImpl implements IMultiAvChatReporter {
    static IPatchRedirector $redirector_;
    private ConcurrentHashMap<String, String> pageParam;

    public MultiAvChatReporterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.pageParam = new ConcurrentHashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void addActivityToDTWhiteList(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            VideoReport.addToDetectionWhitelist(activity);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindElementExcludeClickForCustomWindow(View view, String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, str, concurrentHashMap);
        } else {
            ((a) b.b(a.class)).g(view, false, null, str, concurrentHashMap);
            VideoReport.reportEvent("imp", view, concurrentHashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindElementWithDynamicParams(View view, IDynamicParams iDynamicParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) iDynamicParams);
        } else {
            VideoReport.setEventDynamicParams(view, iDynamicParams);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindElementWithStaticParams(View view, String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, str, concurrentHashMap);
        } else {
            ((a) b.b(a.class)).a(view, false, null, str, concurrentHashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindPageInfo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.pageParam.clear();
            this.pageParam.putAll(com.tencent.mobileqq.qqlive.room.multichat.utils.b.e(j3));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindPageParamsToRootView(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) str);
        } else {
            VideoReport.setPageId(view, str);
            VideoReport.setPageParams(view, new PageParams(getPageInfo()));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateAnchorAcceptEventParam(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 28, (Object) this, j3);
        }
        ConcurrentHashMap<String, String> pageInfo = getPageInfo();
        pageInfo.put("qqlive_lm_guest_qq", String.valueOf(j3));
        return pageInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateAnchorRejectEventParam(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 29, (Object) this, j3);
        }
        ConcurrentHashMap<String, String> pageInfo = getPageInfo();
        pageInfo.put("qqlive_lm_guest_qq", String.valueOf(j3));
        return pageInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateApplyFloatingWindowElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_button_status", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateBottomFunctionElementParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_buttom_area_button", String.valueOf(2));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateCapabilityElementParam(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_guest_set", String.valueOf(i3));
        concurrentHashMap.put("qqlive_lm_guest_qq", String.valueOf(j3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateGuestSeatElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_guest_action", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateInviteAudienceEventParam(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 27, (Object) this, j3);
        }
        ConcurrentHashMap<String, String> pageInfo = getPageInfo();
        pageInfo.put("qqlive_lm_guest_qq", String.valueOf(j3));
        return pageInfo;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateInviteFloatingWindowElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 24, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_invite_button", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateManageElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_manage_button", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateManageGuestElementParam(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 16, (Object) this, j3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_guest_qq", String.valueOf(j3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateManagementElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_room_tab", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generatePlaySelectionElementParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_play_select", String.valueOf(0));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateRedPotElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(IMultiAvChatReporter.ELEMENT_REDPOT_NUM, String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateSettingsElementParam(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_room_set", String.valueOf(i3));
        concurrentHashMap.put("qqlive_lm_button_kg_status", String.valueOf(!z16 ? 1 : 0));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateStatusFloatingWindowElementParam(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_wheat_button", String.valueOf(i3));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> generateWheatRenameElementParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("qqlive_lm_seat_set", String.valueOf(0));
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public ConcurrentHashMap<String, String> getPageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.pageParam;
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void reportClickForCustomWindow(View view, ConcurrentHashMap<String, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) concurrentHashMap);
        } else {
            VideoReport.reportEvent("clck", view, concurrentHashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void reportCustomEvent(String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) concurrentHashMap);
        } else {
            ((a) b.b(a.class)).reportEvent(str, concurrentHashMap);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void traverseExposure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            VideoReport.traverseExposure();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void updatePageInfo(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.pageParam.putAll(d.a(j3));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter
    public void bindPageInfo(long j3, LiveRoomExtraInfo liveRoomExtraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), liveRoomExtraInfo);
        } else {
            this.pageParam.clear();
            this.pageParam.putAll(com.tencent.mobileqq.qqlive.room.multichat.utils.b.f(j3, liveRoomExtraInfo));
        }
    }
}
