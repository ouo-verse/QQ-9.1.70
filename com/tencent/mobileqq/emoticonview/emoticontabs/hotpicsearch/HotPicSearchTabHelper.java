package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/HotPicSearchTabHelper;", "Lcom/tencent/mobileqq/emoticonview/AbsEmoticonPanelLifecycleObserver;", "providerID", "", "(I)V", "getTag", "", "interestedIn", "", "onItemTabClick", "", "position", "popUpSearchWindow", "inputText", "prepareData", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class HotPicSearchTabHelper extends AbsEmoticonPanelLifecycleObserver {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "HotPicSearchTabHelper";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/HotPicSearchTabHelper$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HotPicSearchTabHelper(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }

    private final void popUpSearchWindow(String inputText) {
        ((IEmosmService) QRoute.api(IEmosmService.class)).showSearchEmoticonPanel(this.mPanelController.getHostInterface(), inputText, false);
    }

    private final String prepareData() {
        return this.mPanelController.getHostInterface().getInputBarText();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{13};
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onItemTabClick(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, position);
            return;
        }
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        if (panelDataList != null && position < panelDataList.size()) {
            if (18 == panelDataList.get(position).type) {
                popUpSearchWindow(prepareData());
                ReportController.o(null, "dc00898", "", "", "0X800C0DC", "0X800C0DC", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "onItemTabClick, panelDataList = " + panelDataList + ", position = " + position);
    }
}
