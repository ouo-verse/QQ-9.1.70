package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.MatchFriendPhotoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.NowShowVideoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes16.dex */
public class ProfileCardNewPhotoWallView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileCardNewPhotoWallView";
    private Context ctx;
    protected int height;
    Activity mActivity;
    AppInterface mApp;
    private boolean mCancelRespond;
    protected boolean mIsNightMode;
    protected LayoutInflater mLayoutInflater;
    protected int mMargin;
    protected LinkedList<ProfilePhotoWall> mPhotoList;
    ArrayList<Integer> mPreviewPhotoLocation;
    private float mScale;
    private int mThumbScale;
    String mUin;
    protected int width;

    public ProfileCardNewPhotoWallView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r12v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.StringBuilder] */
    private URL getImageViewUrl(int i3, ProfilePhotoWall profilePhotoWall, URL url) {
        URL url2;
        int size;
        try {
            size = this.mPhotoList.size();
        } catch (MalformedURLException e16) {
            e = e16;
        } catch (Exception e17) {
            e = e17;
        }
        try {
            if (((size != 1 && size != 4 && size != 7) || i3 != 0) && (((size != 2 && size != 5 && size != 8) || (i3 != 0 && i3 != 1)) && ((size != 3 && size != 6 && size != 9) || i3 != 0))) {
                URL url3 = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", profilePhotoWall.getThumbUrl(this.mThumbScale));
                ?? isColorLevel = QLog.isColorLevel();
                i3 = url3;
                url = isColorLevel;
                if (isColorLevel != 0) {
                    ?? sb5 = new StringBuilder();
                    sb5.append("url = ");
                    sb5.append(url3);
                    sb5.append(" profilePhotoWall.getThumbUrl() = ");
                    sb5.append(profilePhotoWall.getThumbUrl(this.mThumbScale));
                    QLog.d(TAG, 2, sb5.toString());
                    i3 = url3;
                    url = sb5;
                }
            } else {
                URL url4 = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", profilePhotoWall.getOriginUrl());
                ?? isColorLevel2 = QLog.isColorLevel();
                i3 = url4;
                url = isColorLevel2;
                if (isColorLevel2 != 0) {
                    ?? sb6 = new StringBuilder();
                    sb6.append("url = ");
                    sb6.append(url4);
                    sb6.append(" profilePhotoWall.getOriginUrl() = ");
                    sb6.append(profilePhotoWall.getOriginUrl());
                    QLog.d(TAG, 2, sb6.toString());
                    i3 = url4;
                    url = sb6;
                }
            }
            return i3;
        } catch (MalformedURLException e18) {
            e = e18;
            url = i3;
            url2 = url;
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.QZONE_COVER, 2, e.toString());
                url2 = url;
            }
            return url2;
        } catch (Exception e19) {
            e = e19;
            url = i3;
            url2 = url;
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.QZONE_COVER, 2, e.toString());
                url2 = url;
            }
            return url2;
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
            this.mThumbScale = 60;
        } else if (max <= 320) {
            this.mThumbScale = 100;
        } else {
            this.mThumbScale = 160;
        }
        setOrientation(1);
    }

    private void setNightMode(URLImageView uRLImageView) {
        if (((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isInNightMode(this.mApp)) {
            return;
        }
        uRLImageView.setColorFilter(0);
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
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            genImg(linkedList, i3, true);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) linkedList, i3);
        }
    }

    public ViewGroup getImageView(int i3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        ProfilePhotoWall profilePhotoWall = this.mPhotoList.get(i17);
        URLDrawable uRLDrawable = null;
        URL imageViewUrl = getImageViewUrl(i17, profilePhotoWall, null);
        if (imageViewUrl != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Resources resources = getResources();
            if (this.mIsNightMode) {
                i18 = R.drawable.kun;
            } else {
                i18 = R.drawable.asd;
            }
            Drawable drawable = resources.getDrawable(i18);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
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
        viewGroup.setOnClickListener(new View.OnClickListener(profilePhotoWall, i17, uRLImageView) { // from class: com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardNewPhotoWallView.1
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
                    iPatchRedirector2.redirect((short) 1, this, ProfileCardNewPhotoWallView.this, profilePhotoWall, Integer.valueOf(i17), uRLImageView);
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
                        ProfileCardNewPhotoWallView profileCardNewPhotoWallView = ProfileCardNewPhotoWallView.this;
                        ReportController.o(profileCardNewPhotoWallView.mApp, "dc00899", "NOW", "", "qq_zlk", "replay_click", 0, 0, profileCardNewPhotoWallView.mUin, "", "", "");
                    } else {
                        Intent intent2 = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putInt("index", this.val$pos);
                        ArrayList<String> arrayList = new ArrayList<>();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        for (int i19 = 0; i19 < ProfileCardNewPhotoWallView.this.mPhotoList.size(); i19++) {
                            ProfilePhotoWall profilePhotoWall3 = ProfileCardNewPhotoWallView.this.mPhotoList.get(i19);
                            if (profilePhotoWall3 instanceof QZonePhotoInfo) {
                                arrayList.add(profilePhotoWall3.getOriginUrl());
                                QZonePhotoInfo qZonePhotoInfo = (QZonePhotoInfo) profilePhotoWall3;
                                arrayList2.add(qZonePhotoInfo.photoId);
                                arrayList3.add(qZonePhotoInfo.time + "");
                            } else if (profilePhotoWall3 instanceof MatchFriendPhotoInfo) {
                                arrayList.add(profilePhotoWall3.getOriginUrl());
                            }
                        }
                        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                        bundle.putBoolean("from_photo_wall", true);
                        if (ProfileCardNewPhotoWallView.this.mApp.getCurrentAccountUin().equals(ProfileCardNewPhotoWallView.this.mUin)) {
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
                        ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation = new ArrayList<>();
                        ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(iArr[0]));
                        ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(iArr[1]));
                        ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getWidth()));
                        ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getHeight()));
                        bundle.putIntegerArrayList("mPreviewPhotoLocation", ProfileCardNewPhotoWallView.this.mPreviewPhotoLocation);
                        intent2.putExtras(bundle);
                        RouteUtils.startActivity(ProfileCardNewPhotoWallView.this.mActivity, intent2, RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY);
                        ProfileCardNewPhotoWallView.this.mActivity.overridePendingTransition(R.anim.f154796s5, R.anim.f154795s4);
                        if (ProfileCardNewPhotoWallView.this.mApp.getCurrentAccountUin().equals(ProfileCardNewPhotoWallView.this.mUin)) {
                            ReportController.o(ProfileCardNewPhotoWallView.this.mApp, "CliOper", "", "", "0X8006A80", "0X8006A80", 0, 0, "", "", "", "");
                        } else {
                            ReportController.o(ProfileCardNewPhotoWallView.this.mApp, "CliOper", "", "", "0X8006A94", "0X8006A94", 0, 0, "", "", "", "");
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mLayoutInflater.inflate(R.layout.b0j, (ViewGroup) null);
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

    public ProfileCardNewPhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mCancelRespond = false;
        this.ctx = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        init();
    }

    public void genImg(LinkedList<ProfilePhotoWall> linkedList, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, linkedList, Integer.valueOf(i3), Boolean.valueOf(z16));
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
        if (i3 == 1) {
            int i19 = this.width;
            linearLayout2.addView(getImageView(i19, (i19 * 2) / 3, 0));
        } else if (i3 == 2) {
            int i26 = (this.width - this.mMargin) / 2;
            ViewGroup imageView2 = getImageView(i26, i26, 0);
            ViewGroup imageView3 = getImageView(i26, i26, 1);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) imageView3.getLayoutParams();
            layoutParams3.setMargins(this.mMargin, 0, 0, 0);
            imageView3.setLayoutParams(layoutParams3);
            linearLayout2.addView(imageView2);
            linearLayout2.addView(imageView3);
        } else if (i3 == 3) {
            int i27 = this.width;
            int i28 = this.mMargin;
            int i29 = ((i27 - i28) * 2) / 3;
            int i36 = i29 / 2;
            int i37 = (i29 - i28) / 2;
            ViewGroup imageView4 = getImageView(i29, i29, 0);
            LinearLayout linearLayout3 = new LinearLayout(this.ctx);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.setMargins(this.mMargin, 0, 0, 0);
            linearLayout3.setLayoutParams(layoutParams4);
            linearLayout3.setOrientation(1);
            ViewGroup imageView5 = getImageView(i36, i37, 1);
            ViewGroup imageView6 = getImageView(i36, i37, 2);
            ((LinearLayout.LayoutParams) imageView6.getLayoutParams()).setMargins(0, this.mMargin, 0, 0);
            linearLayout3.addView(imageView5);
            linearLayout3.addView(imageView6);
            linearLayout2.addView(imageView4);
            linearLayout2.addView(linearLayout3);
        }
        if (z16) {
            removeAllViews();
        }
        addView(linearLayout2);
    }

    public void setNightMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mIsNightMode = z16;
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
    }
}
