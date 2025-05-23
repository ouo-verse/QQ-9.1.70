package com.tencent.mobileqq.qqlive.anchor.live.end;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qqlive.data.QQLiveEndRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import qg4.e;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AnchorLiveEndFragment extends QQLiveBaseFragment {
    static IPatchRedirector $redirector_;
    private static QQLiveEndPageInfo F;
    private IQQLiveEndView D;
    private final EndLiveClickCallback E;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class QlsLiveCloseType {
        private static final /* synthetic */ QlsLiveCloseType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final QlsLiveCloseType CLOSE_BY_ADMIN;
        public static final QlsLiveCloseType CLOSE_BY_ANCHOR_SELF;
        public int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55245);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            QlsLiveCloseType qlsLiveCloseType = new QlsLiveCloseType("CLOSE_BY_ANCHOR_SELF", 0, 0);
            CLOSE_BY_ANCHOR_SELF = qlsLiveCloseType;
            QlsLiveCloseType qlsLiveCloseType2 = new QlsLiveCloseType("CLOSE_BY_ADMIN", 1, 1);
            CLOSE_BY_ADMIN = qlsLiveCloseType2;
            $VALUES = new QlsLiveCloseType[]{qlsLiveCloseType, qlsLiveCloseType2};
        }

        QlsLiveCloseType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static QlsLiveCloseType valueOf(String str) {
            return (QlsLiveCloseType) Enum.valueOf(QlsLiveCloseType.class, str);
        }

        public static QlsLiveCloseType[] values() {
            return (QlsLiveCloseType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements EndLiveClickCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnchorLiveEndFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onCloseClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AnchorLiveEndFragment.this.getQBaseActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onFollowClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onHeadIconClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onNickClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onPopularityClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onRecommendClick(int i3, QQLiveEndRecommendInfo qQLiveEndRecommendInfo, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), qQLiveEndRecommendInfo, view);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback
        public void onTimeClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            F = new QQLiveEndPageInfo();
        }
    }

    public AnchorLiveEndFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.D = null;
            this.E = new a();
        }
    }

    private void th() {
        int i3 = getArguments().getInt("qls_close_type", 0);
        String string = getArguments().getString("qls_close_reason", "");
        if (i3 != QlsLiveCloseType.CLOSE_BY_ANCHOR_SELF.value && !TextUtils.isEmpty(string)) {
            e.a(string, null);
        }
    }

    public static void uh(Context context, QQLiveEndPageInfo qQLiveEndPageInfo, String str, QlsLiveCloseType qlsLiveCloseType) {
        F = qQLiveEndPageInfo;
        Intent intent = new Intent();
        intent.putExtra("moduleId", "qq_live");
        intent.putExtra("qls_close_type", qlsLiveCloseType.value);
        intent.putExtra("qls_close_reason", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivityForTool.class, AnchorLiveEndFragment.class);
    }

    @Override // com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            setStatusBarImmersive();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.h9a, viewGroup, false);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.f59602t6);
            IQQLiveEndView anchorEndLiveView = ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).getAnchorEndLiveView(getQBaseActivity(), F, this.E);
            this.D = anchorEndLiveView;
            frameLayout.addView(anchorEndLiveView.getView(), new FrameLayout.LayoutParams(-1, -1));
            th();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
