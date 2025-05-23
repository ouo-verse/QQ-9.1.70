package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tencent.im.usercategory.ExtendFriendUserCategory$GetUserStatusReq;

/* compiled from: P */
/* loaded from: classes35.dex */
public class EntryExtendForbiddenUtilsImpl implements IEntryExtendForbiddenUtils {
    private static final String SP_EXPAND_FORBIDDEN_INFO = "sp_expand_forbidden_info";
    private static final String SP_EXTEND_FRIEND_CHECK_INTERVAL = "sp_entry_expand_check_interval";
    private static final String SP_EXTEND_FRIEND_FORBIDDEN_END_TIME = "sp_extend_forbidden_end_time";
    private static final String SP_EXTEND_FRIEND_IS_FORBIDDEN = "sp_extend_friend_is_forbidden";
    private static final String SP_EXTEND_FRIEND_LAST_VISIT = "sp_entry_expand_last_visit";
    private static final String SP_EXTEND_FRIEND_LENGGONG = "sp_entry_expand_lenggong";
    private static final String TAG = "EntryExpandForbiddenUtilsImpl";
    QQCustomDialog qqDialog;

    private void dialog(final Activity activity, final AppRuntime appRuntime, ExpandForbiddenInfo expandForbiddenInfo) {
        String forbiddenTips = expandForbiddenInfo.getForbiddenTips();
        long forbiddenDuration = expandForbiddenInfo.getForbiddenDuration();
        final boolean isForbidden = expandForbiddenInfo.isForbidden();
        final int forbiddenType = expandForbiddenInfo.getForbiddenType();
        final String faceAuthUrl = expandForbiddenInfo.getFaceAuthUrl();
        final SpannableStringBuilder dialogMessage = getDialogMessage(activity, forbiddenTips, false, forbiddenDuration, isForbidden);
        final int dialogTitleId = getDialogTitleId(isForbidden, forbiddenType);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl$1$b */
            /* loaded from: classes35.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (TextUtils.isEmpty(faceAuthUrl)) {
                        return;
                    }
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    AppRuntime appRuntime = appRuntime;
                    if (appRuntime instanceof BaseQQAppInterface) {
                        EntryExtendForbiddenUtilsImpl.this.handleJumpAction((BaseQQAppInterface) appRuntime, activity, faceAuthUrl);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl$1$c */
            /* loaded from: classes35.dex */
            class c implements DialogInterface.OnClickListener {
                c() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    EntryExtendForbiddenUtilsImpl.this.qqDialog.dismiss();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                EntryExtendForbiddenUtilsImpl.this.qqDialog = DialogUtil.createCustomDialog(activity, 230);
                EntryExtendForbiddenUtilsImpl.this.qqDialog.setTitle(activity.getString(dialogTitleId)).setMessage(dialogMessage).setPositiveButton(EntryExtendForbiddenUtilsImpl.this.getDialogConfirmTextId(forbiddenType), new b()).setOnKeyListener(new a());
                EntryExtendForbiddenUtilsImpl.this.qqDialog.getTitleTextView().setTypeface(Typeface.DEFAULT_BOLD);
                EntryExtendForbiddenUtilsImpl.this.qqDialog.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
                if (forbiddenType == 6) {
                    EntryExtendForbiddenUtilsImpl.this.qqDialog.setNegativeButton(R.string.x6o, new c());
                    EntryExtendForbiddenUtilsImpl.this.qqDialog.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
                }
                if (activity.isFinishing()) {
                    return;
                }
                if (EntryExtendForbiddenUtilsImpl.this.isInNightMode()) {
                    EntryExtendForbiddenUtilsImpl entryExtendForbiddenUtilsImpl = EntryExtendForbiddenUtilsImpl.this;
                    entryExtendForbiddenUtilsImpl.adaptionNightMode(entryExtendForbiddenUtilsImpl.qqDialog);
                }
                EntryExtendForbiddenUtilsImpl entryExtendForbiddenUtilsImpl2 = EntryExtendForbiddenUtilsImpl.this;
                entryExtendForbiddenUtilsImpl2.reportExposure(entryExtendForbiddenUtilsImpl2.qqDialog, forbiddenType, isForbidden ? 1 : 0);
                EntryExtendForbiddenUtilsImpl.this.qqDialog.show();
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl$1$a */
            /* loaded from: classes35.dex */
            class a implements DialogInterface.OnKeyListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    if (i3 != 4) {
                        return false;
                    }
                    EntryExtendForbiddenUtilsImpl.this.qqDialog.dismiss();
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDialogConfirmTextId(int i3) {
        if (i3 == 6) {
            return R.string.x6u;
        }
        return R.string.f198574n3;
    }

    private int getDialogTitleId(boolean z16, int i3) {
        if (i3 == 6) {
            return R.string.x6v;
        }
        if (z16) {
            return R.string.f198594n5;
        }
        return R.string.f198424mo;
    }

    private static ArrayList<String> getForbidTimeText(Activity activity, long j3) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (j3 > 86400) {
            arrayList.add(String.valueOf(((j3 + 86400) - 1) / 86400));
            arrayList.add(activity.getString(R.string.imp));
        } else if (j3 > 3600) {
            arrayList.add(String.valueOf(((j3 + 3600) - 1) / 3600));
            arrayList.add(activity.getString(R.string.brw));
        } else if (j3 > 60) {
            arrayList.add(String.valueOf(((j3 + 60) - 1) / 60));
            arrayList.add(activity.getString(R.string.ca5));
        } else if (j3 > 0) {
            arrayList.add(String.valueOf(j3));
            arrayList.add(activity.getString(R.string.hax));
        } else {
            arrayList.add(String.valueOf(0));
            arrayList.add(activity.getString(R.string.hax));
        }
        return arrayList;
    }

    private static void getInfoFromNet(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getForbiddenInfo ");
        }
        new ExtendFriendUserCategory$GetUserStatusReq().ReqForbiddenInfo.set(true);
        if (ExpandCmdHandler.d(qQAppInterface) == null) {
            QLog.w(TAG, 1, "getForbiddenInfo cmdHandler is null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleJumpAction(BaseQQAppInterface baseQQAppInterface, Context context, String str) {
        if (!str.startsWith("http") && !str.startsWith("https")) {
            ax c16 = bi.c(baseQQAppInterface, context, str);
            if (c16 != null) {
                c16.b();
                return;
            }
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInNightMode() {
        return QQTheme.isNowThemeIsNight();
    }

    private boolean isNeedGetInfoFromNet(AppRuntime appRuntime) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
    public SpannableStringBuilder getDialogMessage(Activity activity, String str, boolean z16, long j3, boolean z17) {
        Drawable drawable;
        ForegroundColorSpan foregroundColorSpan;
        if (TextUtils.isEmpty(str)) {
            str = BaseApplication.getContext().getString(R.string.x6t);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (isInNightMode()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(TipsElementData.DEFAULT_COLOR)), 0, spannableStringBuilder.length(), 17);
        }
        if (!z16 && z17) {
            spannableStringBuilder.append((CharSequence) "\n");
            SpannableString spannableString = new SpannableString("\u56fe");
            int dip2px = ViewUtils.dip2px(20.0f);
            if (isInNightMode()) {
                drawable = activity.getResources().getDrawable(R.drawable.n3n);
            } else {
                drawable = activity.getResources().getDrawable(R.drawable.d3d);
            }
            drawable.setBounds(0, 0, dip2px, dip2px);
            spannableString.setSpan(new ImageSpan(drawable, 0), 0, spannableString.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) " ");
            String string = activity.getString(R.string.f198604n6);
            ArrayList<String> forbidTimeText = getForbidTimeText(activity, j3);
            String format = String.format(" %s ", forbidTimeText.get(0));
            SpannableString spannableString2 = new SpannableString(string + format + forbidTimeText.get(1));
            spannableString2.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString2.length(), 17);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, spannableString2.length(), 17);
            int length = string.length();
            int length2 = string.length() + format.length();
            spannableString2.setSpan(new AbsoluteSizeSpan(14, true), length, length2, 33);
            if (QQTheme.isNowThemeIsNight()) {
                foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF5967"));
            } else {
                foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#D94C58"));
            }
            spannableString2.setSpan(foregroundColorSpan, length, length2, 17);
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        return spannableStringBuilder;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
    public boolean isNeedShowDiaLog(Context context, AppRuntime appRuntime) {
        return false;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
    public boolean isNetSupport(Context context) {
        if (AppNetConnInfo.isNetSupport()) {
            return true;
        }
        QQToast.makeText(context, 1, "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", 0).show();
        return false;
    }

    public void reportExposure(QQCustomDialog qQCustomDialog, int i3, int i16) {
        VideoReport.setPageId(qQCustomDialog, "pg_kl_limit_windows");
        HashMap hashMap = new HashMap(2);
        hashMap.put("kl_limit_reason", String.valueOf(i3));
        hashMap.put("kl_isForbidden", String.valueOf(i16));
        VideoReport.setPageParams(qQCustomDialog, new PageParams(hashMap));
        if (i3 == 6) {
            VideoReport.setElementId(qQCustomDialog.getBtnight(), "em_kl_limit_windows_todo_btn");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adaptionNightMode(QQCustomDialog qQCustomDialog) {
        Context context;
        Resources resources;
        View findViewById;
        if (qQCustomDialog == null || (context = qQCustomDialog.getContext()) == null || (resources = context.getResources()) == null) {
            return;
        }
        View findViewById2 = qQCustomDialog.findViewById(R.id.vdy);
        if (findViewById2 == null) {
            findViewById = qQCustomDialog.findViewById(R.id.bja);
        } else {
            findViewById = findViewById2.findViewById(R.id.bja);
        }
        if (findViewById == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(resources.getColor(R.color.skin_color_white));
        gradientDrawable.setCornerRadius(x.c(context, 4.0f));
        findViewById.setBackgroundDrawable(gradientDrawable);
        qQCustomDialog.getTitleTextView().setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        qQCustomDialog.getBtnight().setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        qQCustomDialog.getBtnLeft().setTextColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
    public void notifyFaceRealNameVerified(AppRuntime appRuntime) {
    }

    private void setExtendInfoToSp(AppRuntime appRuntime, ExpandForbiddenInfo expandForbiddenInfo) {
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IEntryExtendForbiddenUtils
    public void showDialog(Activity activity, AppRuntime appRuntime) {
    }
}
