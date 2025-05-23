package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.guild.feed.api.IGuildShareToFeedApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.haoliyou.util.JumpUriUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.CommonPreviewLayerFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.util.QQToastUtil;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardFileOption extends ForwardFileBaseOption implements al {
    static IPatchRedirector $redirector_;
    private static FileManagerEntity S;
    private static ChatMessage T;
    private boolean D;
    boolean E;
    protected boolean F;
    boolean G;
    private ImageView H;
    boolean I;
    boolean J;
    private PopupWindow K;
    private TextView L;
    private ForwardNewVersionDialog M;
    private SparseIntArray N;
    private EditText P;
    private TextView Q;
    private EditText R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ForwardFileOption forwardFileOption = ForwardFileOption.this;
            if (!forwardFileOption.I) {
                forwardFileOption.x0(-8);
            }
            if (ForwardFileOption.this.R != null) {
                ForwardFileOption.this.R.setFocusable(true);
                ForwardFileOption.this.R.setFocusableInTouchMode(true);
                ForwardFileOption.this.R.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (i3 == 4 || i3 == 6 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f210639d;

        /* renamed from: e, reason: collision with root package name */
        private int f210640e;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.f210639d = charSequence.toString();
                this.f210640e = i3;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (charSequence.toString().length() > 36) {
                ForwardFileOption.this.x0(-4);
                if (i17 > 0 && i16 < i17) {
                    int i18 = this.f210640e;
                    if (!this.f210639d.equals("")) {
                        ForwardFileOption.this.P.setText(this.f210639d);
                        ForwardFileOption.this.P.setSelection(i18);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f210643d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f210644e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f210645f;

        e(String str, String str2, String str3) {
            this.f210643d = str;
            this.f210644e = str2;
            this.f210645f = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardFileOption.this, str, str2, str3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardFileOption forwardFileOption = ForwardFileOption.this;
                forwardFileOption.I = true;
                forwardFileOption.M(this.f210643d, this.f210644e, this.f210645f);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardFileOption.this.reportClickContentAction();
                ForwardFileOption.this.p0(view.findViewById(R.id.f165268ck2));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFileOption.this.X();
                ForwardFileOption.this.y0(view);
                ReportController.o(null, "dc00898", "", "", "0X800AEEA", "0X800AEEA", 0, 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageButton f210650d;

        i(ImageButton imageButton) {
            this.f210650d = imageButton;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this, (Object) imageButton);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                this.f210650d.setBackgroundColor(Color.argb(25, 0, 0, 0));
            } else if (motionEvent.getAction() == 1) {
                this.f210650d.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ForwardFileOption.this.X();
                ForwardFileOption.this.y0(view);
                ReportController.o(null, "dc00898", "", "", "0X800AEEA", "0X800AEEA", 0, 0, "", "", "", "");
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageButton f210653d;

        k(ImageButton imageButton) {
            this.f210653d = imageButton;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this, (Object) imageButton);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                this.f210653d.setBackgroundColor(Color.argb(25, 0, 0, 0));
            } else if (motionEvent.getAction() == 1) {
                this.f210653d.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ImageView imageView;
            ImageView imageView2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int b06 = ForwardFileOption.this.b0();
                if (motionEvent.getAction() == 0) {
                    View findViewById = view.findViewById(R.id.cjx);
                    if (findViewById != null) {
                        findViewById.setBackgroundColor(Color.argb(25, 0, 0, 0));
                    }
                    if (b06 != 1 && b06 == 3 && (imageView2 = (ImageView) view.findViewById(R.id.f165269ck3)) != null) {
                        imageView2.setImageResource(R.drawable.cms);
                    }
                } else if (motionEvent.getAction() == 1) {
                    View findViewById2 = view.findViewById(R.id.cjx);
                    if (findViewById2 != null) {
                        findViewById2.setBackgroundColor(Color.argb(0, 0, 0, 0));
                    }
                    if (b06 != 1 && b06 == 3 && (imageView = (ImageView) view.findViewById(R.id.f165269ck3)) != null) {
                        imageView.setImageResource(R.drawable.cmr);
                    }
                }
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ForwardFileOption.this.reportClickContentAction();
                ForwardFileOption.this.p0(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f210657d;

        n(View view) {
            this.f210657d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardFileOption.this, (Object) view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                View view3 = this.f210657d;
                if (view3 != null) {
                    view3.setBackgroundColor(Color.argb(25, 0, 0, 0));
                }
            } else if (motionEvent.getAction() == 1 && (view2 = this.f210657d) != null) {
                view2.setBackgroundColor(Color.argb(0, 0, 0, 0));
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            S = null;
            T = null;
        }
    }

    public ForwardFileOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.E = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.L = null;
        this.mForwardReportType = 10;
    }

    private void H(int i3, RelativeLayout relativeLayout, ImageView imageView, AsyncImageView asyncImageView, LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {
        ImageButton imageButton = new ImageButton(this.mActivity);
        imageButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
        imageButton.setImageResource(R.drawable.qfile_file_rename_edit_icon);
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.c(imageButton, HardCodeUtil.qqStr(R.string.f230376yz), Button.class.getName());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        linearLayout.addView(imageButton, layoutParams);
        linearLayout.setGravity(16);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        imageButton.setPadding(0, 0, 0, 0);
        layoutParams.setMargins(0, 0, 0, 0);
        imageButton.setBackgroundColor(Color.argb(0, 0, 0, 0));
        relativeLayout.setOnClickListener(null);
        relativeLayout.setOnTouchListener(null);
        textView.setOnClickListener(new h());
        textView.setOnTouchListener(new i(imageButton));
        imageButton.setOnClickListener(new j());
        imageButton.setOnTouchListener(new k(imageButton));
        this.L.setOnClickListener(q0());
        asyncImageView.setOnClickListener(q0());
        imageView.setOnClickListener(q0());
        this.L.setOnTouchListener(w0(linearLayout2));
        asyncImageView.setOnTouchListener(w0(linearLayout2));
        imageView.setOnTouchListener(w0(linearLayout2));
    }

    private void I(int i3, RelativeLayout relativeLayout) {
        relativeLayout.setPadding(0, i3, 0, i3);
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        uRLImageView.setId(R.id.f165268ck2);
        uRLImageView.setAdjustViewBounds(true);
        uRLImageView.setMaxHeight(ViewUtils.dip2px(140.0f));
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(uRLImageView, layoutParams);
        this.H = uRLImageView;
        View view = new View(this.mActivity);
        view.setId(R.id.cjx);
        view.setBackgroundColor(Color.argb(0, 0, 0, 0));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, R.id.f165268ck2);
        layoutParams2.addRule(8, R.id.f165268ck2);
        layoutParams2.addRule(5, R.id.f165268ck2);
        layoutParams2.addRule(7, R.id.f165268ck2);
        relativeLayout.addView(view, layoutParams2);
        Drawable c06 = c0();
        if (c06 != null) {
            uRLImageView.setImageDrawable(c06);
        }
    }

    private void J(ForwardFileInfo forwardFileInfo, int i3, int i16, int i17, int i18, int i19, int i26, RelativeLayout relativeLayout) {
        String str;
        long j3;
        String str2;
        LinearLayout linearLayout;
        relativeLayout.setPadding(0, i19, 0, i19);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setId(R.id.cjw);
        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i16, i17);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.leftMargin = i3;
        relativeLayout.addView(imageView, layoutParams);
        AsyncImageView asyncImageView = new AsyncImageView(this.mActivity);
        asyncImageView.setId(R.id.cjy);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i26, i26);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.cjw);
        relativeLayout.addView(asyncImageView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.mActivity);
        linearLayout2.setId(R.id.f165267ck1);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Color.argb(0, 0, 0, 0));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(0, R.id.cjy);
        layoutParams3.addRule(9);
        relativeLayout.addView(linearLayout2, layoutParams3);
        EllipsizingTextView ellipsizingTextView = new EllipsizingTextView(this.mActivity, null);
        this.L = ellipsizingTextView;
        ellipsizingTextView.setId(R.id.cjz);
        this.L.setMaxLines(1);
        this.L.setIncludeFontPadding(false);
        this.L.setLineSpacing(0.0f, 1.0f);
        this.L.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.L.setTextColor(Color.parseColor("#777777"));
        this.L.setTextSize(1, 14.0f);
        linearLayout2.addView(this.L);
        LinearLayout linearLayout3 = new LinearLayout(this.mActivity);
        linearLayout3.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, i18);
        layoutParams4.addRule(3, R.id.cjz);
        linearLayout2.addView(linearLayout3, layoutParams4);
        TextView textView = new TextView(this.mActivity);
        textView.setId(R.id.f165266ck0);
        textView.setSingleLine();
        textView.setGravity(16);
        textView.setTextColor(Color.parseColor("#777777"));
        textView.setTextSize(1, 14.0f);
        linearLayout3.addView(textView);
        SimpleModeHelper.o(this.L, textView, imageView, layoutParams);
        LinearLayout linearLayout4 = new LinearLayout(this.mActivity);
        linearLayout4.setId(R.id.cjx);
        linearLayout4.setOrientation(1);
        linearLayout4.setBackgroundColor(Color.argb(0, 0, 0, 0));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(6, R.id.f165267ck1);
        layoutParams5.addRule(8, R.id.f165267ck1);
        relativeLayout.addView(linearLayout4, layoutParams5);
        if (forwardFileInfo != null) {
            str = forwardFileInfo.f();
        } else {
            str = this.f210629m;
        }
        String str3 = str;
        if (forwardFileInfo != null) {
            j3 = forwardFileInfo.g();
        } else {
            j3 = this.f210628i;
        }
        FileManagerUtil.setFileIcon(asyncImageView, str3);
        this.L.setText(str3);
        textView.setText(com.tencent.mobileqq.filemanager.util.q.h(j3, this.mActivity.getResources().getDisplayMetrics().densityDpi) + " ");
        S(forwardFileInfo, FileManagerUtil.getFileType(str3));
        if (this.J) {
            k0();
            str2 = str3;
            linearLayout = linearLayout3;
            H(i17, relativeLayout, imageView, asyncImageView, linearLayout3, textView, linearLayout4);
        } else {
            str2 = str3;
            linearLayout = linearLayout3;
        }
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            String h16 = com.tencent.mobileqq.filemanager.util.q.h(j3, this.mActivity.getResources().getDisplayMetrics().densityDpi);
            AccessibilityUtil.n(linearLayout, true);
            AccessibilityUtil.n(this.L, false);
            AccessibilityUtil.n(textView, false);
            AccessibilityUtil.n(imageView, false);
            AccessibilityUtil.n(asyncImageView, false);
            linearLayout.setContentDescription(str2 + "\uff0c" + h16);
        }
    }

    private void K(int i3, int i16, RelativeLayout relativeLayout) {
        relativeLayout.setPadding(0, i3, 0, i3);
        URLImageView uRLImageView = new URLImageView(this.mActivity);
        uRLImageView.setId(R.id.f165268ck2);
        uRLImageView.setAdjustViewBounds(true);
        uRLImageView.setMaxHeight(ViewUtils.dip2px(140.0f));
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(uRLImageView, layoutParams);
        View view = new View(this.mActivity);
        view.setId(R.id.cjx);
        view.setBackgroundColor(Color.argb(0, 0, 0, 0));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(6, R.id.f165268ck2);
        layoutParams2.addRule(8, R.id.f165268ck2);
        layoutParams2.addRule(5, R.id.f165268ck2);
        layoutParams2.addRule(7, R.id.f165268ck2);
        relativeLayout.addView(view, layoutParams2);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setId(R.id.f165269ck3);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i16, i16);
        layoutParams3.addRule(13);
        relativeLayout.addView(imageView, layoutParams3);
        Drawable c06 = c0();
        if (c06 != null) {
            uRLImageView.setImageDrawable(c06);
        }
        imageView.setImageResource(R.drawable.cmr);
    }

    private boolean L() {
        Bundle bundle;
        String str;
        String str2;
        String str3;
        if (!this.J || (bundle = this.mExtraData) == null || bundle.size() < 9) {
            return true;
        }
        if (this.mExtraData.containsKey("fileinfo_array") && this.mExtraData.getParcelableArrayList("fileinfo_array").size() > 1) {
            return true;
        }
        ForwardFileInfo e06 = e0();
        String charSequence = this.L.getText().toString();
        if (e06 != null) {
            str = e06.f();
        } else {
            str = this.f210629m;
        }
        if (charSequence.equals(str)) {
            return true;
        }
        if (e06 != null) {
            str2 = e06.l();
        } else {
            str2 = this.f210627h;
        }
        int lastIndexOf = str2.lastIndexOf(47);
        if (lastIndexOf > -1 && lastIndexOf < str2.length()) {
            str3 = str2.substring(0, lastIndexOf + 1) + charSequence;
        } else {
            str3 = "";
        }
        if (T(str2, str3)) {
            if (e06 != null) {
                e06.y(charSequence);
                e06.C(str3);
                e06.N(10000);
                this.mExtraData.putParcelable("fileinfo", e06);
            }
            this.mExtraData.putString(AppConstants.Key.FORWARD_FILEPATH, str3);
            this.mIntent.putExtras(this.mExtraData);
            return true;
        }
        x0(-1);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, String str2, String str3) {
        String str4;
        EditText editText = this.P;
        if (editText == null) {
            return;
        }
        String obj = editText.getText().toString();
        this.P.setSelection(obj.length());
        if (obj.length() <= 0) {
            x0(-6);
            return;
        }
        if (!obj.matches("[^/\\\\\\\\<>*:?|\\\"]+")) {
            x0(-7);
            return;
        }
        String str5 = obj + str3;
        TextView textView = this.L;
        String str6 = "";
        if (textView == null) {
            str4 = "";
        } else {
            str4 = textView.getText().toString();
        }
        if (str5.equals(str4)) {
            ReportController.o(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
            r0();
            return;
        }
        if (!str5.equals(str)) {
            int lastIndexOf = str2.lastIndexOf(47);
            if (lastIndexOf > -1 && lastIndexOf < str2.length()) {
                str6 = str2.substring(0, lastIndexOf + 1);
            }
            File[] listFiles = new File(str6).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (!file.isDirectory() && file.getName().toLowerCase().equals(str5.toLowerCase())) {
                        x0(-3);
                        return;
                    }
                }
            }
        }
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setText(str5);
        }
        x0(1);
        ReportController.o(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
        r0();
    }

    private boolean N(RecentUser recentUser) {
        if (recentUser.getType() == 1) {
            return true;
        }
        return false;
    }

    private boolean O(RecentUser recentUser) {
        if (!Utils.J(recentUser.uin)) {
            if ((recentUser.getType() == 0 && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) || ((recentUser.getType() == 1 && isSupportAbility(com.tencent.mobileqq.forward.e.P3) && !isHotChat(recentUser.uin)) || recentUser.getType() == 3000 || FileManagerUtil.getTempSessionType(recentUser.getType()) != -1 || recentUser.getType() == 10027)) {
                return true;
            }
            return false;
        }
        if (recentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN) && isSupportAbility(com.tencent.mobileqq.forward.e.S3) && isFromSharePullRecentList()) {
            return true;
        }
        return false;
    }

    private boolean P(RecentUser recentUser) {
        if ((recentUser.getType() == 1 && !isHotChat(recentUser.uin)) || ((recentUser.getType() == 0 && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) || recentUser.getType() == 3000 || -1 != FileManagerUtil.getTempSessionType(recentUser.getType()))) {
            return true;
        }
        if (recentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN) && isSupportAbility(com.tencent.mobileqq.forward.e.S3) && isFromSharePullRecentList()) {
            return true;
        }
        return false;
    }

    private boolean Q(RecentUser recentUser) {
        if ((recentUser.getType() == 0 && !CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) || recentUser.getType() == 1 || recentUser.getType() == 3000 || recentUser.getType() == 1006 || recentUser.getType() == 1004 || recentUser.getType() == 1000) {
            return true;
        }
        if (recentUser.uin.equalsIgnoreCase(AppConstants.DATALINE_PC_UIN) && isSupportAbility(com.tencent.mobileqq.forward.e.S3) && isFromSharePullRecentList()) {
            return true;
        }
        return false;
    }

    private boolean R(RecentUser recentUser) {
        if (recentUser.getType() == 9501) {
            return false;
        }
        if ((recentUser.getType() == 1006 && !isSupportAbility(com.tencent.mobileqq.forward.e.U3)) || recentUser.getType() == 6004 || recentUser.getType() == 7000) {
            return false;
        }
        if (isFromFav() && recentUser.getType() == 6005) {
            return false;
        }
        if ((isFromFav() && recentUser.getType() == 6003) || recentUser.getType() == 1000) {
            return false;
        }
        return true;
    }

    private void S(ForwardFileInfo forwardFileInfo, int i3) {
        if (forwardFileInfo != null && forwardFileInfo.l() != null && forwardFileInfo.l().length() > 1 && i3 != 1 && i3 != 0 && i3 != 2 && forwardFileInfo.g() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            this.J = true;
        }
        if (forwardFileInfo == null && this.f210629m.length() > 1 && this.f210627h.length() > 1 && this.f210628i < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            this.J = true;
        }
        long[] longArray = this.mExtraData.getLongArray(AppConstants.Key.FORWARD_NT_ROOT_MSG_IDS);
        if (longArray != null && longArray.length > 0 && longArray[0] != 0) {
            this.J = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean T(String str, String str2) {
        Throwable th5;
        FileChannel fileChannel;
        FileChannel channel;
        File file = new File(str);
        File file2 = new File(str2);
        FileChannel fileChannel2 = null;
        try {
            channel = new FileInputStream(file).getChannel();
        } catch (IOException e16) {
            e = e16;
            fileChannel = null;
        } catch (Throwable th6) {
            th5 = th6;
            fileChannel = null;
        }
        try {
            fileChannel2 = new FileOutputStream(file2).getChannel();
            long size = channel.size();
            int i3 = 0;
            while (0 < size) {
                long j3 = i3;
                long transferTo = channel.transferTo(j3, size, fileChannel2);
                if (transferTo > 0) {
                    i3 = (int) (j3 + transferTo);
                    size -= transferTo;
                }
            }
            try {
                channel.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            if (fileChannel2 != null) {
                try {
                    fileChannel2.close();
                    return true;
                } catch (IOException e18) {
                    e18.printStackTrace();
                    return true;
                }
            }
            return true;
        } catch (IOException e19) {
            e = e19;
            fileChannel = fileChannel2;
            fileChannel2 = channel;
            try {
                e.printStackTrace();
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th7) {
                th5 = th7;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                }
                if (fileChannel == null) {
                    try {
                        fileChannel.close();
                        throw th5;
                    } catch (IOException e29) {
                        e29.printStackTrace();
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (Throwable th8) {
            th5 = th8;
            fileChannel = fileChannel2;
            fileChannel2 = channel;
            if (fileChannel2 != null) {
            }
            if (fileChannel == null) {
            }
        }
    }

    public static ForwardFileInfo U(FileManagerEntity fileManagerEntity) {
        return V(fileManagerEntity, null);
    }

    public static ForwardFileInfo V(FileManagerEntity fileManagerEntity, ChatMessage chatMessage) {
        if (fileManagerEntity == null) {
            fileManagerEntity = new FileManagerEntity();
        }
        S = fileManagerEntity;
        T = chatMessage;
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(g0(fileManagerEntity));
        forwardFileInfo.w(fileManagerEntity.getCloudType());
        forwardFileInfo.E(fileManagerEntity.nSessionId);
        forwardFileInfo.V(fileManagerEntity.uniseq);
        forwardFileInfo.y(fileManagerEntity.fileName);
        forwardFileInfo.z(fileManagerEntity.fileSize);
        forwardFileInfo.C(fileManagerEntity.getFilePath());
        forwardFileInfo.x(fileManagerEntity.WeiYunFileId);
        if (!TextUtils.isEmpty(fileManagerEntity.strLargeThumPath)) {
            forwardFileInfo.G(fileManagerEntity.strLargeThumPath);
        } else if (!TextUtils.isEmpty(fileManagerEntity.strMiddleThumPath)) {
            forwardFileInfo.G(fileManagerEntity.strMiddleThumPath);
        } else {
            forwardFileInfo.G(fileManagerEntity.strThumbPath);
        }
        String str = fileManagerEntity.Uuid;
        if (str != null) {
            forwardFileInfo.Z(str);
        }
        long j3 = fileManagerEntity.TroopUin;
        if (j3 != 0) {
            forwardFileInfo.B(j3);
        }
        String str2 = fileManagerEntity.strTroopFileID;
        if (str2 != null) {
            forwardFileInfo.M(str2);
        }
        return forwardFileInfo;
    }

    private String W(String str) {
        String str2 = AppConstants.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        try {
            BaseImageUtil.compressImagetoSize(this.app.getApplication(), str, str2, 600, 800);
        } catch (Exception unused) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X() {
        Bundle bundle = this.mExtraData;
        int i3 = -1;
        if (bundle == null) {
            return -1;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayList != null) {
            if (parcelableArrayList.size() > 1) {
                i3 = 4;
            }
        } else {
            int i16 = this.mExtraData.getInt("uintype", 0);
            if (i16 != -1) {
                if (i16 != 0) {
                    if (i16 == 1) {
                        i3 = 1;
                    }
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 3;
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800AEE9", "0X800AEE9", i3, 0, "", "", "", "");
        return i3;
    }

    private boolean Y(FileManagerEntity fileManagerEntity, View view) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        boolean z16 = false;
        if (runtime instanceof QQAppInterface) {
            com.tencent.mobileqq.filemanager.openbrowser.e eVar = new com.tencent.mobileqq.filemanager.openbrowser.e((QQAppInterface) runtime, fileManagerEntity);
            com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
            eVar2.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), eVar);
            ArrayList arrayList = new ArrayList();
            RFWLayerItemMediaInfo d16 = mb1.a.f416517a.d(fileManagerEntity);
            if (d16 != null) {
                arrayList.add(d16);
                eVar2.j(arrayList);
                eVar2.i(0);
                Bundle bundle = new Bundle();
                if (fileManagerEntity.nFileType == 2) {
                    z16 = true;
                }
                bundle.putBoolean("hide_save_button", z16);
                RFWLayerLaunchUtil.jumpToGallery(a0(view), arrayList, 0, QQGalleryActivity.class, CommonPreviewLayerFragment.class, bundle);
                return true;
            }
        }
        return false;
    }

    @NotNull
    private View.OnTouchListener Z() {
        return new l();
    }

    private ImageView a0(View view) {
        if (view instanceof ImageView) {
            return (ImageView) view;
        }
        return new ImageView(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b0() {
        String str;
        ForwardFileInfo e06 = e0();
        if (e06 == null && TextUtils.isEmpty(this.f210627h)) {
            return -1;
        }
        if (e06 == null && TextUtils.isEmpty(this.f210627h)) {
            return -1;
        }
        if (e06 != null) {
            str = e06.f();
        } else {
            str = this.f210627h;
        }
        String i06 = i0();
        int fileType = FileManagerUtil.getFileType(str);
        if (fileType == 0 && FileUtils.fileExistsAndNotEmpty(i06)) {
            return 2;
        }
        if (fileType == 2 && FileUtils.fileExistsAndNotEmpty(i06)) {
            return 3;
        }
        return 1;
    }

    private Drawable c0() {
        String i06 = i0();
        if (FileUtils.fileExistsAndNotEmpty(i06)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
            obtain.mFailedDrawable = BaseURLDrawableHelper.getFailedDrawable();
            return URLDrawable.getFileDrawable(i06, obtain);
        }
        return null;
    }

    private String d0(String str) {
        String str2 = "";
        if (this.P == null) {
            return "";
        }
        String str3 = ".rename";
        if (!str.endsWith(".rename")) {
            str3 = "";
        } else {
            str = str.replace(".rename", "");
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > -1 && lastIndexOf < str.length()) {
            String substring = str.substring(0, lastIndexOf);
            this.P.setText(substring);
            this.P.setSelection(substring.length());
            str2 = str.substring(lastIndexOf, str.length());
        } else {
            this.P.setText(str);
            this.P.setSelection(str.length());
        }
        return str2 + str3;
    }

    private ForwardFileInfo e0() {
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo != null) {
            return forwardFileInfo;
        }
        ArrayList<ForwardFileInfo> arrayList = this.f210625e;
        if (arrayList != null && arrayList.size() == 1) {
            return this.f210625e.get(0);
        }
        return null;
    }

    private void f0() {
        String h06 = h0();
        if (FileUtils.fileExistsAndNotEmpty(h06)) {
            File file = new File(h06);
            this.f210629m = file.getName();
            this.f210627h = h06;
            this.f210628i = file.length();
        }
    }

    public static int g0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return 10000;
        }
        switch (fileManagerEntity.getCloudType()) {
            case 1:
                return 10002;
            case 2:
                return 10003;
            case 3:
            case 5:
                return 10000;
            case 4:
            default:
                if (!QLog.isColorLevel()) {
                    return 10000;
                }
                QLog.e("dataline", 2, "FileManagerEntity->cloudType \u8f6c ForwardFileInfo->type\uff0c \u672a\u8bc6\u522b\u7684cloudType[" + fileManagerEntity.getCloudType());
                return 10000;
            case 6:
            case 7:
                if (com.tencent.mobileqq.filemanager.util.q.f(fileManagerEntity.getFilePath())) {
                    return 10000;
                }
                return 10009;
            case 8:
                return 10011;
        }
    }

    private String h0() {
        String l3;
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo == null) {
            l3 = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            if (TextUtils.isEmpty(l3)) {
                l3 = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
            }
        } else {
            l3 = forwardFileInfo.l();
            if (TextUtils.isEmpty(l3)) {
                l3 = this.f210624d.p();
            }
        }
        if (TextUtils.isEmpty(l3)) {
            return null;
        }
        int fileType = FileManagerUtil.getFileType(l3);
        if (fileType != -1 && fileType != 11) {
            return l3;
        }
        return W(l3);
    }

    private String i0() {
        ForwardFileInfo e06 = e0();
        if (e06 != null) {
            return e06.p();
        }
        String stringExtra = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_THUMB);
        if (TextUtils.isEmpty(stringExtra)) {
            return this.mExtraData.getString(AppConstants.Key.FORWARD_THUMB);
        }
        return stringExtra;
    }

    private void j0() {
        Intent intent = this.mIntent;
        if (intent != null && intent.getBooleanExtra("system_share", false)) {
            JumpUriUtils.grantShareUriPermissions(intent, this.mActivity);
        }
    }

    private void k0() {
        if (this.N != null) {
            return;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.N = sparseIntArray;
        sparseIntArray.put(1, R.string.f187653uk);
        this.N.put(-1, R.string.f187593ue);
        this.N.put(-2, R.string.f187603uf);
        this.N.put(-3, R.string.f187573uc);
        this.N.put(-4, R.string.f187663ul);
        this.N.put(-5, R.string.f187633ui);
        this.N.put(-6, R.string.f187613ug);
        this.N.put(-7, R.string.f187643uj);
        this.N.put(-8, R.string.f187583ud);
    }

    private boolean l0(FileManagerEntity fileManagerEntity, int i3) {
        if (i3 == 2) {
            return FileUtils.fileExists(fileManagerEntity.getFilePath());
        }
        if (i3 != 0) {
            return false;
        }
        if (!FileUtils.fileExists(fileManagerEntity.getFilePath()) && !FileUtils.fileExists(fileManagerEntity.strLargeThumPath) && !FileUtils.fileExists(fileManagerEntity.strMiddleThumPath)) {
            return false;
        }
        return true;
    }

    private boolean m0(int i3) {
        if (i3 != 2 && i3 != 3 && i3 != 0 && i3 != 7 && i3 != 6 && i3 != 10 && i3 != 9) {
            return false;
        }
        return true;
    }

    private boolean n0() {
        int height = this.mActivity.getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        this.mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if ((height * 3) / 4 > rect.bottom) {
            return true;
        }
        return false;
    }

    private TextWatcher o0() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(View view) {
        ForwardFileInfo e06 = e0();
        if (e06 != null) {
            int type = e06.getType();
            QLog.d("ForwardOption.ForwardFileOption", 1, "openFile: forwardFileType=" + type);
            if (type == 10006 && b0() == 2) {
                String h06 = h0();
                QLog.d("ForwardOption.ForwardFileOption", 1, "openFile: path=" + h06);
                if (mb1.a.f416517a.l() && !TextUtils.isEmpty(h06)) {
                    sm2.a.f433978a.c(h06, a0(view));
                    return;
                } else {
                    z0(h0(), String.valueOf(e06.k()));
                    return;
                }
            }
            if (type != 10000 && type != 10001 && type != 10002 && type != 10004 && type != 10003) {
                if (type == 10006) {
                    FileManagerEntity D = this.app.getFileManagerDataCenter().D(e06.n());
                    if (D != null) {
                        com.tencent.mobileqq.troop.data.t n3 = TroopFileUtils.n(this.app, D);
                        long longExtra = this.mIntent.getLongExtra("last_time", 0L);
                        String stringExtra = this.mIntent.getStringExtra("sender_uin");
                        int fileType = FileManagerUtil.getFileType(n3.f294987u);
                        if (fileType != 0 && fileType != 2) {
                            QFileUtils.q(this.app, this.mActivity, n3, stringExtra, longExtra, 12);
                            return;
                        }
                        if (mb1.a.f416517a.l() && l0(D, fileType) && Y(D, view)) {
                            QLog.d("ForwardOption.ForwardFileOption", 1, "openTroopFileViewer");
                            return;
                        } else {
                            QFileUtils.n(this.app, this.mActivity, null, null, e06.k(), n3, stringExtra, longExtra, -1, 12, null, false, false);
                            return;
                        }
                    }
                    return;
                }
                if (type == 10013) {
                    long longExtra2 = this.mIntent.getLongExtra("qfavId", -1L);
                    if (longExtra2 != -1) {
                        QfavHelper.u(this.mActivity, "", longExtra2);
                        return;
                    }
                    return;
                }
                return;
            }
            FileManagerEntity D2 = this.app.getFileManagerDataCenter().D(e06.n());
            if (D2 != null) {
                int i3 = D2.nFileType;
                if (i3 != 0 && i3 != 2) {
                    ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(this.mActivity, new com.tencent.mobileqq.filemanager.openbrowser.d(this.app, D2), new com.tencent.mobileqq.filemanager.openbrowser.c().d(12));
                    return;
                } else if (mb1.a.f416517a.l() && Y(D2, view)) {
                    QLog.d("ForwardOption.ForwardFileOption", 1, "openFileViewer");
                    return;
                } else {
                    kc1.a.c(D2).b(this.mActivity, type, 12);
                    return;
                }
            }
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.f210627h)) {
            try {
                FileManagerEntity newEntityByLocalFileInfo = FileManagerUtil.newEntityByLocalFileInfo(new FileInfo(this.f210627h));
                if (newEntityByLocalFileInfo != null) {
                    kc1.a.c(newEntityByLocalFileInfo).a(this.mActivity, 12);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private View.OnClickListener q0() {
        return new m();
    }

    private void r0() {
        PopupWindow popupWindow = this.K;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    private void s0(View view) {
        if (this.K == null) {
            return;
        }
        this.I = false;
        EditText editText = this.R;
        if (editText != null) {
            editText.setFocusable(false);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        inputMethodManager.toggleSoftInput(1000, 2);
        this.K.setFocusable(true);
        this.K.setOutsideTouchable(true);
        this.K.update();
        this.K.setBackgroundDrawable(new BitmapDrawable());
        this.K.showAtLocation(view.getRootView(), 80, 0, 0);
        if (n0()) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
        ForwardNewVersionDialog forwardNewVersionDialog = this.M;
        if (forwardNewVersionDialog != null) {
            forwardNewVersionDialog.z0();
        }
        this.P.setFocusable(true);
        this.P.setFocusableInTouchMode(true);
        this.P.requestFocus();
    }

    private TextView.OnEditorActionListener t0() {
        return new b();
    }

    private View.OnLongClickListener u0() {
        return new d();
    }

    private View.OnClickListener v0() {
        String str;
        String str2;
        String str3;
        ForwardFileInfo e06 = e0();
        if (e06 != null) {
            str = e06.f();
        } else {
            str = this.f210629m;
        }
        if (e06 != null) {
            str2 = e06.l();
        } else {
            str2 = this.f210627h;
        }
        TextView textView = this.L;
        if (textView != null) {
            str3 = textView.getText().toString();
        } else {
            str3 = "";
        }
        return new e(str, str2, d0(str3));
    }

    private View.OnTouchListener w0(View view) {
        return new n(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x0(int i3) {
        int i16;
        SparseIntArray sparseIntArray = this.N;
        if (sparseIntArray != null) {
            i16 = sparseIntArray.get(i3, 0);
        } else {
            i16 = 0;
        }
        int i17 = 1;
        if (i3 == 1) {
            i17 = 2;
        } else if (i3 != -1) {
            i17 = 0;
        }
        QQToast.makeText(this.mActivity, i17, i16, 0).show();
        return i17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(View view) {
        if (this.K == null) {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f168649g70, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true);
            this.K = popupWindow;
            popupWindow.setContentView(inflate);
            this.K.setSoftInputMode(16);
            this.P = (EditText) inflate.findViewById(R.id.f26340d_);
            this.Q = (TextView) inflate.findViewById(R.id.trd);
            this.P.setSingleLine(false);
            this.P.setMaxLines(2);
            this.P.setOnEditorActionListener(t0());
            this.P.setOnLongClickListener(u0());
            this.P.addTextChangedListener(o0());
            this.Q.setOnClickListener(v0());
            ForwardNewVersionDialog forwardNewVersionDialog = this.M;
            if (forwardNewVersionDialog != null) {
                this.R = (EditText) forwardNewVersionDialog.findViewById(R.id.input);
            }
            if (this.R != null) {
                this.K.setOnDismissListener(new a());
            }
        }
        s0(view);
    }

    private void z0(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardFileOption", 2, "startToGalleryWithPath: path=" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            AIOImageData aIOImageData = new AIOImageData();
            aIOImageData.F = str;
            aIOImageData.G = str;
            aIOImageData.H = str;
            aIOImageData.Q = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
            bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
            enterImageGallery(bundle, new AIOImageProviderService(this.app.getCurrentUin(), str2, 0, null), aIOImageData);
            reportClickContentAction();
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public void a(Activity activity, @NonNull String str, int i3, com.tencent.mobileqq.guild.feed.api.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, activity, str, Integer.valueOf(i3), gVar);
            return;
        }
        SharePublishGuildFeedParam c16 = c();
        if (c16 != null) {
            if ((c16 instanceof SharePublishGuildFeedParam.VideoTypeParam) && !FileUtils.fileExists(((SharePublishGuildFeedParam.VideoTypeParam) c16).getPlayUrl())) {
                QQToast.makeText(activity, "\u89c6\u9891\u6587\u4ef6\u672a\u4e0b\u8f7d", 0).show();
                gVar.a(false);
            } else if ((c16 instanceof SharePublishGuildFeedParam.PhotoTypeParam) && !FileUtils.fileExists(((SharePublishGuildFeedParam.PhotoTypeParam) c16).getPicUrl())) {
                QQToast.makeText(activity, "\u56fe\u7247\u6587\u4ef6\u672a\u4e0b\u8f7d", 0).show();
                gVar.a(false);
            } else {
                ((IGuildShareToFeedApi) QRoute.api(IGuildShareToFeedApi.class)).shareToFeedPostAwareForbidden(activity, str, c16, i3, gVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean allowRecentUser(@NonNull RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) recentUser)).booleanValue();
        }
        if (recentUser.getType() != 1000 && super.allowRecentUser(recentUser)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.al
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (c() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.G && allowFriendAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.O3);
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.V3);
        }
        if (!this.G && allowDiscussAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.Q3);
        }
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo != null && forwardFileInfo.getType() != 10006 && this.f210624d.getType() != 10003 && this.f210624d.getType() != 10002) {
            this.f210624d.getType();
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.P3);
        }
        if (this.f210624d != null) {
            if (DataLineHandler.V2(this.app.getFileManagerDataCenter().D(this.f210624d.n()))) {
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.S3);
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.X3);
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.f211017e4);
            }
        } else {
            ArrayList<ForwardFileInfo> arrayList = this.f210625e;
            if (arrayList != null) {
                Iterator<ForwardFileInfo> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ForwardFileInfo next = it.next();
                    if (next != null && DataLineHandler.V2(this.app.getFileManagerDataCenter().D(next.n()))) {
                        this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.S3);
                        this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.X3);
                        this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.f211017e4);
                        break;
                    }
                }
            } else {
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.S3);
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.X3);
                this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.f211017e4);
            }
        }
        Intent intent = this.mIntent;
        if (intent != null && intent.getBooleanExtra("isFromFavorites", false)) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.S3);
        }
        Intent intent2 = this.mIntent;
        if (intent2 != null && intent2.getBooleanExtra("k_smartdevice", true) && allowSmartDeviceAbility() && m0(FileManagerUtil.getFileType(h0()))) {
            this.mForwardAbilities.add(com.tencent.mobileqq.forward.e.W3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
            return;
        }
        if (this.F && !this.E && -1 != FileManagerUtil.getTempSessionType(bundle.getInt("uintype"))) {
            Activity activity = this.mActivity;
            DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.f171410et3), this.mActivity.getString(R.string.erz), (String) null, this.mActivity.getString(R.string.i5e), new f(), (DialogInterface.OnClickListener) null).show();
        } else {
            super.buildForwardDialog(i3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ForwardFileInfo e06 = e0();
        int f16 = BaseAIOUtils.f(8.0f, this.mActivity.getResources());
        int f17 = BaseAIOUtils.f(12.0f, this.mActivity.getResources());
        BaseAIOUtils.f(14.0f, this.mActivity.getResources());
        int f18 = BaseAIOUtils.f(15.0f, this.mActivity.getResources());
        int f19 = BaseAIOUtils.f(16.0f, this.mActivity.getResources());
        int f26 = BaseAIOUtils.f(18.0f, this.mActivity.getResources());
        int f27 = BaseAIOUtils.f(20.0f, this.mActivity.getResources());
        int f28 = BaseAIOUtils.f(32.0f, this.mActivity.getResources());
        int f29 = BaseAIOUtils.f(40.0f, this.mActivity.getResources());
        RelativeLayout relativeLayout = new RelativeLayout(this.mActivity);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setOnClickListener(new g());
        relativeLayout.setOnTouchListener(Z());
        relativeLayout.setLayoutParams(layoutParams);
        int b06 = b0();
        if (b06 == 2) {
            I(f18, relativeLayout);
        } else if (b06 == 3) {
            K(f18, f29, relativeLayout);
        } else if (b06 == 1) {
            J(e06, f16, f17, f19, f26, f27, f28, relativeLayout);
        } else {
            relativeLayout.setPadding(0, f27, 0, f27);
            AnimationTextView animationTextView = new AnimationTextView(this.mActivity);
            animationTextView.setText(getDialogContent());
            animationTextView.setMaxLines(2);
            animationTextView.setEllipsize(TextUtils.TruncateAt.END);
            animationTextView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.f157116k8));
            animationTextView.setTextSize(14.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = ScreenUtil.dip2px(10.0f);
            relativeLayout.addView(animationTextView, layoutParams2);
            relativeLayout.setOnClickListener(null);
        }
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.forward.al
    @Nullable
    public SharePublishGuildFeedParam c() {
        String l3;
        int fileType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (SharePublishGuildFeedParam) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo == null) {
            l3 = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            if (TextUtils.isEmpty(l3)) {
                l3 = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
            }
        } else {
            l3 = forwardFileInfo.l();
        }
        if (TextUtils.isEmpty(l3)) {
            ForwardFileInfo e06 = e0();
            if (e06 != null) {
                fileType = FileManagerUtil.getFileType(e06.f());
            } else {
                fileType = -1;
            }
        } else {
            fileType = FileManagerUtil.getFileType(l3);
        }
        int b06 = b0();
        String str = "";
        if (fileType == 0 && (b06 == 2 || b06 == 1)) {
            String string = this.mExtraData.getString(AppConstants.Key.FORWARD_FILE_SAVED_OREDIT);
            if (!TextUtils.isEmpty(string)) {
                l3 = string;
            }
            if (TextUtils.isEmpty(l3)) {
                l3 = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH, "");
            }
            if (TextUtils.isEmpty(l3)) {
                l3 = this.mForwardThumb;
            }
            if (TextUtils.isEmpty(l3)) {
                QLog.w("ForwardOption.ForwardFileOption", 1, "forwardToGuildFeed extraData: " + this.mExtraData);
            } else {
                str = l3;
            }
            return new SharePublishGuildFeedParam.PhotoTypeParam(str);
        }
        if (fileType != 2 && b06 != 3) {
            return null;
        }
        ForwardFileInfo e07 = e0();
        if (e07 == null) {
            QLog.w("ForwardOption.ForwardFileOption", 1, "ForwardFileInfo  is null: ");
            return null;
        }
        String l16 = e07.l();
        String p16 = e07.p();
        if (TextUtils.isEmpty(l16)) {
            QLog.w("ForwardOption.ForwardFileOption", 1, "forwardToGuildFeed video path is null ");
            l16 = "";
        }
        if (p16 == null) {
            QLog.w("ForwardOption.ForwardFileOption", 1, "coverUrl is null");
        } else {
            str = p16;
        }
        return new SharePublishGuildFeedParam.VideoTypeParam(str, l16);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        if (this.mIntent.getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, 0) == 9501) {
            return arrayList;
        }
        for (RecentUser recentUser : list) {
            if (recentUser != null && R(recentUser)) {
                if (this.F && P(recentUser)) {
                    arrayList.add(recentUser);
                } else if (this.D && Q(recentUser)) {
                    arrayList.add(recentUser);
                } else if (this.G && N(recentUser)) {
                    arrayList.add(recentUser);
                } else if (O(recentUser)) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.a
    public boolean isInterceptForwardDialog(ResultRecord resultRecord) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) resultRecord)).booleanValue();
        }
        if (resultRecord.getUinType() == 1000 && (activity = this.mActivity) != null) {
            QQToastUtil.showQQToastInUiThread(1, activity.getResources().getString(R.string.f237347gt));
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 19001 && i16 == -1) {
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            String h06 = h0();
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardFileOption", 2, "refresh forward preview,editPicPath:" + stringExtra + " :currentFile" + h06);
            }
            if (!h06.equals(stringExtra)) {
                this.isURLDrawablFoward = false;
                this.mExtraData.remove(AppConstants.Key.FORWARD_MSG_FOR_PIC);
                this.mExtraData.putString(AppConstants.Key.FORWARD_FILEPATH, stringExtra);
                this.mExtraData.putString(AppConstants.Key.FORWARD_EXTRA, stringExtra);
                this.mExtraData.putBoolean(AEEditorConstants.EXTRA_IS_EDITED_PIC, true);
                ForwardFileInfo e06 = e0();
                if (e06 != null) {
                    e06.C(stringExtra);
                    e06.G(stringExtra);
                }
                Drawable c06 = c0();
                if (c06 != null) {
                    this.H.setImageDrawable(c06);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption
    protected String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mAppContext.getString(R.string.hiy);
    }

    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        boolean z19 = false;
        this.isNOneedJumpToAIO = this.mIntent.getBooleanExtra("forward _key_nojump", false);
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo != null) {
            int c16 = forwardFileInfo.c();
            String l3 = this.f210624d.l();
            boolean z26 = !TextUtils.isEmpty(l3);
            if (this.f210624d.getType() == 10006) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.F = z16;
            if (this.f210624d.getType() == 10009) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.G = z17;
            if (c16 == 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.D = z18;
            if (z26 && (c16 == 3 || FileUtils.fileExists(l3))) {
                z19 = true;
            }
            this.E = z19;
        } else {
            ArrayList<ForwardFileInfo> arrayList = this.f210625e;
            if (arrayList != null) {
                this.G = true;
                Iterator<ForwardFileInfo> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ForwardFileInfo next = it.next();
                    if (next != null && next.c() != 6) {
                        this.G = false;
                        break;
                    }
                }
            } else if (this.mIntent.getBooleanExtra("isFromShare", false)) {
                this.E = true;
            }
        }
        this.mExtraData.putString("leftBackText", MobileQQ.sMobileQQ.getString(R.string.hvn));
        if (this.f210624d == null && TextUtils.isEmpty(this.f210627h)) {
            f0();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ae, code lost:
    
        if (r2.M == 1) goto L74;
     */
    @Override // com.tencent.mobileqq.forward.ForwardFileBaseOption, com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean realForwardTo() {
        Intent m3;
        boolean z16;
        boolean z17;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        boolean booleanExtra = this.mIntent.getBooleanExtra("isFromShare", false);
        boolean z18 = true;
        if (!L()) {
            return true;
        }
        ForwardFileInfo e06 = e0();
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            if (e06 == null) {
                obj = "null";
            } else {
                obj = e06;
            }
            objArr[0] = obj;
            QLog.d("IS_FROM_FILE", 2, objArr);
        }
        j0();
        if (isMultiTarget2Send()) {
            getMultiTargetWithoutDataLine();
            Intent m16 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + booleanExtra);
            }
            if (this.mFromSharePanelPreviewAndSend) {
                m16.putExtras(this.mExtraData);
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
                return false;
            }
            if (booleanExtra) {
                this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mou));
                m16.addFlags(268435456);
                m16.addFlags(67108864);
                m16.putExtras(this.mExtraData);
                boolean handleForwardFromFavorite = handleForwardFromFavorite(m16);
                if (this.isFormJump) {
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
                } else if (!handleForwardFromFavorite) {
                    ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
                }
            } else if (!this.isNOneedJumpToAIO) {
                if (!this.mExtraData.containsKey("is_from_file")) {
                    Bundle bundle = this.mExtraData;
                    if (e06 == null || (e06.c() != 3 && e06.M != 1)) {
                        z18 = false;
                    }
                    bundle.putBoolean("is_from_file", z18);
                }
                m16.putExtras(this.mExtraData);
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m16, null);
            }
            m16.putExtras(this.mExtraData);
            this.mActivity.setResult(-1, m16);
            return false;
        }
        int i3 = this.mExtraData.getInt("uintype");
        String string = this.mExtraData.getString("uin");
        if (i3 == 1008) {
            m3 = new Intent(this.mActivity, (Class<?>) ChatActivity.class);
            m3.putExtra("chat_subType", ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getPublicAccountAioClass(string, this.app));
        } else {
            m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + booleanExtra);
        }
        if (booleanExtra) {
            this.mExtraData.putString("leftBackText", HardCodeUtil.qqStr(R.string.mot));
            m3.addFlags(268435456);
            m3.addFlags(67108864);
            m3.putExtras(this.mExtraData);
            boolean handleForwardFromFavorite2 = handleForwardFromFavorite(m3);
            if (this.isFormJump) {
                this.mActivity.startActivity(m3);
            } else if (!handleForwardFromFavorite2) {
                ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
            }
        } else if (!this.isNOneedJumpToAIO) {
            if (!this.mExtraData.containsKey("is_from_file")) {
                Bundle bundle2 = this.mExtraData;
                if (e06 != null) {
                    if (e06.c() != 3) {
                        z16 = true;
                    } else {
                        z16 = true;
                    }
                    z17 = z16;
                    bundle2.putBoolean("is_from_file", z17);
                }
                z17 = false;
                bundle2.putBoolean("is_from_file", z17);
            }
            m3.putExtras(this.mExtraData);
            ForwardUtils.w(this.app, this.mActivity, this.mAppContext, m3, null);
        }
        m3.putExtras(this.mExtraData);
        this.mActivity.setResult(-1, m3);
        this.mActivity.finish();
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected int realShareToQfav() {
        FileManagerEntity D;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        int i3 = 0;
        if (S != null) {
            if (new QfavBuilder(3).u(this.app, this.mActivity, S, T, true)) {
                S = null;
            }
            i3 = -1;
        } else {
            if (this.f210624d != null && (D = this.app.getFileManagerDataCenter().D(this.f210624d.n())) != null && new QfavBuilder(3).u(this.app, this.mActivity, D, null, true)) {
                S = null;
            }
            i3 = -1;
        }
        int i16 = i3;
        if (i16 == 0) {
            cooperation.qqfav.d.d(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineMultiple(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) intent);
            return;
        }
        ArrayList parcelableArrayList = this.mExtraData.getParcelableArrayList("fileinfo_array");
        ArrayList<String> arrayList = null;
        if (parcelableArrayList == null) {
            parcelableArrayList = null;
        }
        ArrayList arrayList2 = (ArrayList) this.mExtraData.get("android.intent.extra.STREAM");
        if (arrayList2.size() > 1) {
            if (parcelableArrayList == null) {
                arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    arrayList.add(ForwardFileBaseOption.r(this.mActivity, (Uri) arrayList2.get(i3)));
                }
            }
        } else {
            if (!L()) {
                return;
            }
            ForwardFileInfo e06 = e0();
            if (e06 != null) {
                arrayList = new ArrayList<>();
                arrayList.add(e06.l());
            }
        }
        intent.putExtra("dataline_forward_type", 100);
        intent.putExtra("sendMultiple", true);
        if (parcelableArrayList == null) {
            intent.putStringArrayListExtra("dataline_forward_pathlist", arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "ForwardFileOption sendDatalineSingle");
        if (!L()) {
            return;
        }
        intent.putExtra("dataline_forward_type", 100);
        ForwardFileInfo forwardFileInfo = this.f210624d;
        if (forwardFileInfo == null) {
            String stringExtra = this.mIntent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
            if (stringExtra == null) {
                stringExtra = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
            }
            intent.putExtra("dataline_forward_path", stringExtra);
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "mForwardFileInfo == null, filePath is " + stringExtra);
            return;
        }
        intent.putExtra("dataline_forward_path", forwardFileInfo.l());
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "mForwardFileInfo != null, mForwardFileInfo.getLocalPath() is " + this.f210624d.l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }
}
