package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UnverifyBlockContainer extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Context f254203d;

    /* renamed from: e, reason: collision with root package name */
    private View f254204e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f254205f;

    /* renamed from: h, reason: collision with root package name */
    AppRuntime f254206h;

    public UnverifyBlockContainer(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void a() {
        View inflate = LayoutInflater.from(this.f254203d).inflate(R.layout.hc7, (ViewGroup) this, true);
        this.f254204e = inflate;
        View findViewById = inflate.findViewById(R.id.f114386t7);
        this.f254205f = (ImageView) this.f254204e.findViewById(R.id.f116596z6);
        findViewById.setOnClickListener(this);
        List<AddFriendBlockedInfo> list = NewFriendVerificationServiceImpl.getService(this.f254206h).addFriendBlockedInfoList;
        int i3 = 8;
        if (list == null || list.size() == 0) {
            this.f254204e.setVisibility(8);
        }
        boolean isShowRedPointAtNewFriendBanner = ((INewFriendVerificationService) this.f254206h.getRuntimeService(INewFriendVerificationService.class, "")).isShowRedPointAtNewFriendBanner();
        ImageView imageView = this.f254205f;
        if (isShowRedPointAtNewFriendBanner) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.f254205f.setVisibility(8);
            ((INewFriendVerificationService) this.f254206h.getRuntimeService(INewFriendVerificationService.class, "")).clearRedPointAtNewFriendBanner();
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity) this.f254203d);
            ReportController.o(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public UnverifyBlockContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public UnverifyBlockContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f254203d = context;
        this.f254206h = MobileQQ.sMobileQQ.waitAppRuntime(null);
        a();
    }
}
