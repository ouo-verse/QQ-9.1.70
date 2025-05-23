package com.tencent.mobileqq.profilecard.bussiness.miniapp;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* loaded from: classes16.dex */
public class MiniAppProfileCardGuestView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private IntimatePlayTogetherMiniGameCardView.b adapter;
    private ColorStateList attrValue;
    private int colorInt;
    private boolean isTheme;
    private Context mContext;
    protected LayoutInflater mLayoutInflater;
    protected RecyclerView mRecyclerView;

    public MiniAppProfileCardGuestView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.mLayoutInflater = from;
        from.inflate(R.layout.cbm, (ViewGroup) this, true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.liy);
        this.mRecyclerView = recyclerView;
        recyclerView.setVisibility(0);
    }

    public void setData(List<MISC$StAppPlayingInfo> list, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, list, str, str2);
            return;
        }
        if (list.size() <= 0) {
            setVisibility(8);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener(str) { // from class: com.tencent.mobileqq.profilecard.bussiness.miniapp.MiniAppProfileCardGuestView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$moreJumpLink;

            {
                this.val$moreJumpLink = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAppProfileCardGuestView.this, (Object) str);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(MiniAppProfileCardGuestView.this.getContext(), this.val$moreJumpLink, LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.miniapp.MiniAppProfileCardGuestView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                        public void onLaunchResult(boolean z16, Bundle bundle) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                            }
                        }
                    });
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        setVisibility(0);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            IntimatePlayTogetherMiniGameCardView.b bVar = new IntimatePlayTogetherMiniGameCardView.b(list, str2);
            this.adapter = bVar;
            bVar.u(LaunchScene.LAUNCH_SCENE_PROFILE_GUEST_CARD);
            this.mRecyclerView.setAdapter(this.adapter);
        }
        setOnClickListener(onClickListener);
    }

    public void setTextColor(ColorStateList colorStateList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) colorStateList);
            return;
        }
        this.isTheme = true;
        this.attrValue = colorStateList;
        this.adapter.w(colorStateList);
    }

    public MiniAppProfileCardGuestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.isTheme = true;
        this.colorInt = i3;
        this.adapter.v(i3);
    }

    public MiniAppProfileCardGuestView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
