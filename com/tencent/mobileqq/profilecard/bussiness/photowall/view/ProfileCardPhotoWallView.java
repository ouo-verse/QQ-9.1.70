package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.NowShowVideoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes16.dex */
public class ProfileCardPhotoWallView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_SHOW_NUM = 4;
    private static final String TAG = "ProfileCardNewPhotoWallView";
    private Context ctx;
    protected int height;
    Activity mActivity;
    AppInterface mApp;
    private boolean mCancelRespond;
    protected Drawable mDefaultD;
    protected int mMargin;
    protected LinkedList<ProfilePhotoWall> mPhotoList;
    ArrayList<Integer> mPreviewPhotoLocation;
    private float mScale;
    private int mThumbmScale;
    String mUin;
    private boolean newStyle;
    private int totalCount;
    protected int width;

    public ProfileCardPhotoWallView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void genImgElegantStyle(LinkedList<ProfilePhotoWall> linkedList, int i3) {
        this.mPhotoList = linkedList;
        int size = linkedList.size();
        int i16 = (this.width - (this.mMargin * 3)) / 4;
        LinearLayout linearLayout = new LinearLayout(this.ctx);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.mMargin;
        for (int i17 = 0; i17 < size && i17 < 4; i17++) {
            ViewGroup imageView = getImageView(i16, i16, i17);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(i16, i16));
            linearLayout.addView(getCardViewLayout(i3, i17, this.mMargin, imageView));
        }
        linearLayout.setLayoutParams(layoutParams);
        removeAllViews();
        addView(linearLayout);
    }

    @NonNull
    private CardView getCardViewLayout(int i3, int i16, int i17, View view) {
        CardView cardView = new CardView(this.ctx);
        cardView.setRadius(4.0f);
        cardView.setCardElevation(0.0f);
        cardView.setContentPadding(0, 0, 0, 0);
        cardView.addView(view);
        if (i16 == 3 && i3 > 4) {
            TextView textView = new TextView(this.ctx);
            textView.setText("" + i3);
            textView.setTextSize(2, (float) 10);
            textView.setTextColor(-1);
            textView.setIncludeFontPadding(false);
            textView.setPadding(8, 0, 8, 0);
            textView.setBackgroundResource(R.drawable.kte);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            textView.setLayoutParams(layoutParams);
            cardView.addView(textView);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (i16 > 0) {
            layoutParams2.setMarginStart(i17);
        }
        cardView.setLayoutParams(layoutParams2);
        return cardView;
    }

    private URL getImageViewUrl(int i3, ProfilePhotoWall profilePhotoWall, URL url) {
        URL url2;
        try {
            int size = this.mPhotoList.size();
            if (((size != 1 && size != 4 && size != 7) || i3 != 0) && (((size != 2 && size != 5 && size != 8) || (i3 != 0 && i3 != 1)) && ((size != 3 && size != 6 && size != 9) || i3 != 0))) {
                url2 = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", profilePhotoWall.getThumbUrl(this.mThumbmScale));
            } else {
                url2 = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", profilePhotoWall.getOriginUrl());
            }
            return url2;
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.QZONE_COVER, 2, e16.toString());
                return url;
            }
            return url;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.QZONE_COVER, 2, e17.toString());
                return url;
            }
            return url;
        }
    }

    private void init() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159311a03);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f16 = displayMetrics.density;
        this.mScale = f16;
        int i3 = displayMetrics.widthPixels;
        this.width = i3 - (dimensionPixelSize * 2);
        int i16 = displayMetrics.heightPixels;
        this.height = i16;
        this.mMargin = (int) ((f16 * 2.0f) + 0.5f);
        int max = Math.max(i3, i16);
        if (max <= 240) {
            this.mThumbmScale = 60;
        } else if (max <= 320) {
            this.mThumbmScale = 100;
        } else {
            this.mThumbmScale = 160;
        }
        setOrientation(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.mCancelRespond) {
            return false;
        }
        return dispatchTouchEvent;
    }

    public void genImg(LinkedList<ProfilePhotoWall> linkedList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            genImg(linkedList, i3, linkedList.size());
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) linkedList, i3);
        }
    }

    public void genImgWithOrigin(LinkedList<ProfilePhotoWall> linkedList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) linkedList, i3);
            return;
        }
        this.mPhotoList = linkedList;
        if (i3 > 3) {
            int i16 = i3 - 3;
            genImg(linkedList, i16);
            int i17 = (this.width - (this.mMargin * 2)) / 3;
            LinearLayout linearLayout = new LinearLayout(this.ctx);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.mMargin;
            for (int i18 = 0; i18 < 3; i18++) {
                ViewGroup imageView = getImageView(i17, i17, i16 + i18);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i17, i17);
                if (i18 != i3 - 1) {
                    layoutParams2.rightMargin = this.mMargin;
                }
                imageView.setLayoutParams(layoutParams2);
                linearLayout.addView(imageView);
            }
            linearLayout.setLayoutParams(layoutParams);
            addView(linearLayout);
            return;
        }
        LinearLayout linearLayout2 = new LinearLayout(this.ctx);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(0);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    int i19 = this.width;
                    int i26 = this.mMargin;
                    int i27 = ((i19 - i26) * 2) / 3;
                    int i28 = i27 / 2;
                    int i29 = (i27 - i26) / 2;
                    View imageView2 = getImageView(i27, i27, 0);
                    LinearLayout linearLayout3 = new LinearLayout(this.ctx);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.setMargins(this.mMargin, 0, 0, 0);
                    linearLayout3.setLayoutParams(layoutParams3);
                    linearLayout3.setOrientation(1);
                    ViewGroup imageView3 = getImageView(i28, i29, 1);
                    ViewGroup imageView4 = getImageView(i28, i29, 2);
                    ((LinearLayout.LayoutParams) imageView4.getLayoutParams()).setMargins(0, this.mMargin, 0, 0);
                    linearLayout3.addView(imageView3);
                    linearLayout3.addView(imageView4);
                    linearLayout2.addView(imageView2);
                    linearLayout2.addView(linearLayout3);
                }
            } else {
                int i36 = (this.width - this.mMargin) / 2;
                View imageView5 = getImageView(i36, i36, 0);
                View imageView6 = getImageView(i36, i36, 1);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) imageView6.getLayoutParams();
                layoutParams4.setMargins(this.mMargin, 0, 0, 0);
                imageView6.setLayoutParams(layoutParams4);
                linearLayout2.addView(imageView5);
                linearLayout2.addView(imageView6);
            }
        } else {
            int i37 = this.width;
            linearLayout2.addView(getImageView(i37, (i37 * 2) / 3, 0));
        }
        removeAllViews();
        addView(linearLayout2);
    }

    public ViewGroup getImageView(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        ProfilePhotoWall profilePhotoWall = this.mPhotoList.get(i17);
        URLDrawable uRLDrawable = null;
        URL imageViewUrl = getImageViewUrl(i17, profilePhotoWall, null);
        if (imageViewUrl != null) {
            if (this.mDefaultD == null) {
                this.mDefaultD = getResources().getDrawable(R.color.a09);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = obtain.mFailedDrawable;
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
            uRLDrawable = URLDrawable.getDrawable(imageViewUrl, obtain);
        }
        ViewGroup viewGroup = (ViewGroup) getImageViewLayout();
        URLImageView uRLImageView = (URLImageView) viewGroup.findViewById(R.id.dhh);
        View findViewById = viewGroup.findViewById(R.id.dho);
        setNightMode(uRLImageView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i16);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, new ColorDrawable(855638016));
        stateListDrawable.addState(View.EMPTY_STATE_SET, new ColorDrawable(0));
        viewGroup.setLayoutParams(layoutParams);
        uRLImageView.setImageDrawable(uRLDrawable);
        uRLImageView.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f172320pe2), Integer.valueOf(i17 + 1)));
        findViewById.setBackgroundDrawable(stateListDrawable);
        viewGroup.setOnClickListener(new View.OnClickListener(profilePhotoWall, i17, uRLImageView) { // from class: com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardPhotoWallView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ URLImageView val$imageView;
            final /* synthetic */ int val$pos;
            final /* synthetic */ ProfilePhotoWall val$profilePhotoWall;

            {
                this.val$profilePhotoWall = profilePhotoWall;
                this.val$pos = i17;
                this.val$imageView = uRLImageView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfileCardPhotoWallView.this, profilePhotoWall, Integer.valueOf(i17), uRLImageView);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    ProfilePhotoWall profilePhotoWall2 = this.val$profilePhotoWall;
                    if (profilePhotoWall2 instanceof NowShowVideoInfo) {
                        Intent intent = new Intent();
                        intent.putExtra("hide_more_button", true);
                        intent.putExtra("hide_operation_bar", true);
                        intent.putExtra("url", ((NowShowVideoInfo) profilePhotoWall2).mJumpUrl);
                        RouteUtils.startActivity(view.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
                        ProfileCardPhotoWallView profileCardPhotoWallView = ProfileCardPhotoWallView.this;
                        ReportController.o(profileCardPhotoWallView.mApp, "dc00899", "NOW", "", "qq_zlk", "replay_click", 0, 0, profileCardPhotoWallView.mUin, "", "", "");
                    } else {
                        Intent intent2 = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putInt("index", this.val$pos);
                        ArrayList<String> arrayList = new ArrayList<>();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        for (int i18 = 0; i18 < ProfileCardPhotoWallView.this.mPhotoList.size(); i18++) {
                            ProfilePhotoWall profilePhotoWall3 = ProfileCardPhotoWallView.this.mPhotoList.get(i18);
                            if (profilePhotoWall3 instanceof QZonePhotoInfo) {
                                arrayList.add(profilePhotoWall3.getOriginUrl());
                                QZonePhotoInfo qZonePhotoInfo = (QZonePhotoInfo) profilePhotoWall3;
                                arrayList2.add(qZonePhotoInfo.photoId);
                                arrayList3.add(qZonePhotoInfo.time + "");
                            }
                        }
                        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                        bundle.putBoolean("from_photo_wall", true);
                        if (ProfileCardPhotoWallView.this.mApp.getCurrentAccountUin().equals(ProfileCardPhotoWallView.this.mUin)) {
                            bundle.putBoolean(IProfileCardConst.KEY_DELETE_ABILITY, true);
                            bundle.putStringArrayList("photoIds", arrayList2);
                            bundle.putStringArrayList("photoTimes", arrayList3);
                        }
                        bundle.putBoolean("SHOW_MENU", true);
                        bundle.putBoolean("IS_EDIT", false);
                        bundle.putBoolean("is_use_path", true);
                        bundle.putBoolean("is_show_action", true);
                        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
                        int[] iArr = new int[2];
                        this.val$imageView.getLocationOnScreen(iArr);
                        ProfileCardPhotoWallView.this.mPreviewPhotoLocation = new ArrayList<>();
                        ProfileCardPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(iArr[0]));
                        ProfileCardPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(iArr[1]));
                        ProfileCardPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getWidth()));
                        ProfileCardPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getHeight()));
                        bundle.putIntegerArrayList("mPreviewPhotoLocation", ProfileCardPhotoWallView.this.mPreviewPhotoLocation);
                        intent2.putExtras(bundle);
                        RouteUtils.startActivity(ProfileCardPhotoWallView.this.mActivity, intent2, RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY);
                        ProfileCardPhotoWallView.this.mActivity.overridePendingTransition(R.anim.f154796s5, R.anim.f154795s4);
                        if (ProfileCardPhotoWallView.this.mApp.getCurrentAccountUin().equals(ProfileCardPhotoWallView.this.mUin)) {
                            ReportController.o(ProfileCardPhotoWallView.this.mApp, "CliOper", "", "", "0X8006A80", "0X8006A80", 0, 0, "", "", "", "");
                        } else {
                            ReportController.o(ProfileCardPhotoWallView.this.mApp, "CliOper", "", "", "0X8006A94", "0X8006A94", 0, 0, "", "", "", "");
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        return viewGroup;
    }

    protected View getImageViewLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return LayoutInflater.from(getContext()).inflate(R.layout.b0j, (ViewGroup) null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
        }
    }

    public void preparePhotoWall(String str, Activity activity, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, activity, appInterface);
            return;
        }
        this.mUin = str;
        this.mActivity = activity;
        this.mApp = appInterface;
    }

    public void setNewStyle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.newStyle = z16;
        }
    }

    @Override // android.view.View
    @TargetApi(9)
    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            super.setOverScrollMode(2);
        }
    }

    public ProfileCardPhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.newStyle = false;
        this.mCancelRespond = false;
        this.totalCount = 0;
        this.ctx = context;
        init();
    }

    public void genImg(LinkedList<ProfilePhotoWall> linkedList, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, linkedList, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.newStyle) {
            genImgElegantStyle(linkedList, i16);
        } else {
            genImgWithOrigin(linkedList, i3);
        }
    }

    private void setNightMode(URLImageView uRLImageView) {
    }
}
