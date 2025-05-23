package com.tencent.timi.game.liveroom.impl.room.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.CoverInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorRoomSettingFragment extends QPublicBaseFragment implements View.OnClickListener {
    private View C;
    private RoundCornerImageView D;
    private TextView E;
    private View F;
    private long G;
    private Uri H;
    private boolean I = false;
    private URLDrawable.URLDrawableOptions J;

    private void doOnBackPressed() {
        getActivity().finish();
    }

    private void initView(View view) {
        this.G = getActivity().getIntent().getLongExtra("roomId", 0L);
        this.C = view.findViewById(R.id.spb);
        this.D = (RoundCornerImageView) view.findViewById(R.id.sp5);
        this.E = (TextView) view.findViewById(R.id.sp8);
        this.F = view.findViewById(R.id.sp6);
        ph(this.C, getActivity());
        float o16 = Utils.o(12.0f, getResources());
        this.D.setRadius(o16, o16, o16, o16);
        view.findViewById(R.id.f164324sp3).setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        String B = cVar.B(this.G, 0);
        String n3 = cVar.n(this.G, 0);
        l.h("AnchorRoomSettingFragment", 1, "init title-" + B + ", cover-" + n3);
        if (TextUtils.isEmpty(B) && TextUtils.isEmpty(n3)) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "initView: \u83b7\u53d6\u623f\u95f4\u4fe1\u606f\u9519\u8bef,\u68c0\u67e5\u623f\u95f4\u5bf9\u8c61\u662f\u5426\u521b\u5efa");
        }
        this.J = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = getResources().getDrawable(R.drawable.o4y);
        URLDrawable.URLDrawableOptions uRLDrawableOptions = this.J;
        uRLDrawableOptions.mLoadingDrawable = drawable;
        uRLDrawableOptions.mFailedDrawable = drawable;
        if (!TextUtils.isEmpty(n3)) {
            this.D.setImageDrawable(URLDrawable.getDrawable(n3, this.J));
        } else {
            this.D.setImageDrawable(drawable);
        }
        this.E.setText(B);
        ((ug4.a) mm4.b.b(ug4.a.class)).i(this, view, "pg_qqlive_roomset", d.a(this.G));
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this.D, false, null, "em_qqlive_cover_edit", new ConcurrentHashMap());
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this.F, false, null, "em_qqlive_title_edit", new ConcurrentHashMap());
    }

    public static void ph(View view, Activity activity) {
        boolean z16 = true;
        if (ImmersiveUtils.isSupporImmersive() != 1) {
            z16 = false;
        }
        l.i("AnchorRoomSetting", "isSupportImmesive = " + z16);
        if (z16) {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + statusBarHeight, layoutParams.rightMargin, layoutParams.bottomMargin);
            view.setLayoutParams(layoutParams);
        }
    }

    private void qh(CoverInfo coverInfo) {
        String str;
        if (coverInfo != null) {
            str = coverInfo.roomLogo16v9;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.D.setImageDrawable(URLDrawable.getDrawable(str, this.J));
            IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(this.G);
            if (J3 != null) {
                QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = J3.getAnchorRoomInfo().roomAttr;
                if (qQLiveAnchorDataRoomAttr == null) {
                    qQLiveAnchorDataRoomAttr = new QQLiveAnchorDataRoomAttr();
                    qQLiveAnchorDataRoomAttr.roomId = J3.getRoomInfo().getRoomId();
                }
                if (coverInfo != null) {
                    qQLiveAnchorDataRoomAttr.poster = coverInfo.roomLogo;
                    qQLiveAnchorDataRoomAttr.poster3v4 = coverInfo.roomLogo3v4;
                    qQLiveAnchorDataRoomAttr.poster16v9 = coverInfo.roomLogo16v9;
                    qQLiveAnchorDataRoomAttr.posterTime = coverInfo.roomLogoTime;
                    qQLiveAnchorDataRoomAttr.posterTime3v4 = coverInfo.roomLogoTime3v4;
                    qQLiveAnchorDataRoomAttr.posterTime16v9 = coverInfo.roomLogoTime16v9;
                }
                J3.startSet(qQLiveAnchorDataRoomAttr, null);
                QLog.i("AnchorRoomSettingFragment", 1, "handleCroppedImg:\u5c01\u9762\u8bbe\u7f6e\u6210\u529f");
                return;
            }
            f.c("\u5c01\u9762\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5\u3002");
        }
    }

    public static void rh(Context context, long j3) {
        Intent intent = new Intent();
        intent.putExtra("roomId", j3);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivityForTool.class, AnchorRoomSettingFragment.class);
    }

    private void sh(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterCropFragment(getActivity(), str, String.valueOf(this.G), 2);
        } else {
            l.e("AnchorRoomSettingFragment", "cropImg but picPath is null");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1) {
            Uri uri = this.H;
            if (uri != null) {
                String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(getContext(), uri);
                if (!TextUtils.isEmpty(realPathFromContentURI)) {
                    sh(realPathFromContentURI);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (intent == null) {
                return;
            }
            CoverInfo coverInfo = (CoverInfo) intent.getSerializableExtra(IQQLiveUtil.COVER_INFO_KEY);
            if (coverInfo != null) {
                qh(coverInfo);
            }
            this.I = false;
            return;
        }
        if (i3 != 3 || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("title");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.E.setText(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f164324sp3) {
            doOnBackPressed();
        } else if (id5 == R.id.sp5) {
            f.c("\u6682\u65f6\u672a\u5f00\u653e\u7f16\u8f91\uff0c\u8bf7\u7559\u610f\u540e\u7eed\u7248\u672c\u5347\u7ea7\u3002");
        } else if (id5 == R.id.sp6) {
            f.c("\u6682\u65f6\u672a\u5f00\u653e\u7f16\u8f91\uff0c\u8bf7\u7559\u610f\u540e\u7eed\u7248\u672c\u5347\u7ea7\u3002");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ht9, viewGroup, false);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !this.I) {
            this.I = true;
            if (stringArrayListExtra.size() > 0) {
                String str = stringArrayListExtra.get(0);
                if (!TextUtils.isEmpty(str)) {
                    sh(str);
                } else {
                    l.e("AnchorRoomSettingFragment", "[onNewIntent] the path is empty");
                }
            }
        }
    }
}
