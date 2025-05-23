package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SearchEmoticonFragment extends AIOEmotionBaseFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    public static String U;
    com.tencent.common.galleryactivity.l G;
    TextView H;
    ImageView I;
    Button J;
    Button K;
    TextView L;
    View M;
    ImageView N;
    private Drawable P;
    private int Q;
    private float R;
    private Activity S;
    private SearchEmoticonWebBean T;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                SearchEmoticonFragment.this.M.setBackgroundColor(Color.parseColor("#F7F7F7"));
                if (SearchEmoticonFragment.this.T.C == 1) {
                    EmojiHomeUiPlugin.openEmojiDetailPage(SearchEmoticonFragment.this.getBaseActivity(), SearchEmoticonFragment.this.sh().getAccount(), 8, SearchEmoticonFragment.this.T.E, false, false);
                    ReportController.o(null, "dc00898", "", "", "0X8009EAF", "0X8009EAF", 0, 0, "", "", "", "");
                    return false;
                }
                if (SearchEmoticonFragment.this.T.C == 2) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(SearchEmoticonFragment.this.S, SearchEmoticonFragment.this.T.G, null, null, null, null, 1005, null);
                    ReportController.o(null, "dc00898", "", "", "0X8009EB1", "0X8009EB1", 0, 0, "", "", "", "");
                    return false;
                }
                if (SearchEmoticonFragment.this.T.C == 3 && !TextUtils.isEmpty(SearchEmoticonFragment.this.T.J)) {
                    SearchEmoticonFragment searchEmoticonFragment = SearchEmoticonFragment.this;
                    searchEmoticonFragment.Jh(searchEmoticonFragment.T.J);
                    return false;
                }
                return false;
            }
            if (motionEvent.getAction() == 0) {
                SearchEmoticonFragment.this.M.setBackgroundColor(Color.parseColor("#DEDEDE"));
                ReportController.o(null, "dc00898", "", "", "0X8009EAE", "0X8009EAE", 0, 0, "", "", "", "");
                return false;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            U = "forward_search_emoticon";
        }
    }

    public SearchEmoticonFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.S = null;
        }
    }

    private void Dh(MessageForPic messageForPic) {
        ThreadManager.getFileThreadHandler().post(new Runnable(messageForPic) { // from class: com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MessageForPic f205167d;

            {
                this.f205167d = messageForPic;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchEmoticonFragment.this, (Object) messageForPic);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                URL url = URLDrawableHelper.getURL(this.f205167d, 1, null);
                if (url != null && AbsDownloader.getFile(url.toString()) == null) {
                    String filePath = AbsDownloader.getFilePath(url.toString());
                    if (!TextUtils.isEmpty(this.f205167d.path) && !TextUtils.isEmpty(filePath)) {
                        FileUtils.copyFile(this.f205167d.path, filePath);
                    }
                }
            }
        });
    }

    @NonNull
    private MessageForPic Eh(String str, String str2) {
        MessageForPic messageForPic = (MessageForPic) com.tencent.mobileqq.service.message.q.d(-2000);
        messageForPic.path = str;
        messageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        messageForPic.thumbMsgUrl = str2;
        messageForPic.bigMsgUrl = str2;
        messageForPic.imageType = 2000;
        return messageForPic;
    }

    public static void Fh(Context context, SearchEmoticonWebBean searchEmoticonWebBean) {
        Intent intent = new Intent();
        intent.putExtra("SearchEmoticonWebBean", searchEmoticonWebBean);
        PublicFragmentActivity.start(context, intent, SearchEmoticonFragment.class);
    }

    public static Intent Gh(MessageForPic messageForPic, int i3, QQAppInterface qQAppInterface, Context context) {
        boolean z16;
        int i16;
        int i17;
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, i3);
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, messageForPic.path);
        intent.putExtra(U, true);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_TASK_KEY, messageForPic.frienduin + messageForPic.uniseq + messageForPic.istroop);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN, messageForPic.frienduin);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, messageForPic.istroop);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH, messageForPic.uuid);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, messageForPic.uniseq);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_ISSEND, messageForPic.issend);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_MD5, messageForPic.md5);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_GROUP_FILEID, messageForPic.groupFileID);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_FILE_SIZE_FLAG, messageForPic.fileSizeFlag);
        intent.putExtras(bundle);
        if (!com.tencent.mobileqq.utils.c.h(messageForPic.msgtype) && (i17 = messageForPic.msgtype) != -3001 && i17 != -30002 && i17 != -30003) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            i16 = 65537;
        } else {
            i16 = 1;
        }
        URL url = URLDrawableHelper.getURL(messageForPic, i16);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, url.toString());
        intent.putExtra(AppConstants.Key.FORWARD_URL_KEY, messageForPic.localUUID);
        URLDrawable n3 = ForwardUtils.n(context, messageForPic);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, n3.getURL().toString());
        if (new File(messageForPic.path).exists()) {
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, messageForPic.path);
        } else {
            String url2 = n3.getURL().toString();
            String str = null;
            if (AbsDownloader.hasFile(url2)) {
                File file = AbsDownloader.getFile(url2);
                if (file != null) {
                    str = file.getAbsolutePath();
                }
            } else {
                File file2 = AbsDownloader.getFile(URLDrawableHelper.getURL(messageForPic, 65537).toString());
                if (file2 != null && file2.exists()) {
                    str = file2.getAbsolutePath();
                }
            }
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, str);
        }
        intent.putExtra(AppConstants.Key.BUSI_TYPE, 1009);
        intent.putExtra(AppConstants.Key.FORWARD_IS_TAB_SEARCH_EMO, true);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh() {
        if (!this.S.isFinishing() && !this.S.isDestroyed()) {
            QQToast.makeText(this.S, 1, HardCodeUtil.qqStr(R.string.t6l), 0).show();
        } else {
            QLog.i("SearchEmoticonFragment", 1, "file not exist, activity is destroyed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(String str, String str2, int i3, QQAppInterface qQAppInterface, URLDrawable uRLDrawable) {
        if (!FileUtils.fileExists(str)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.ac
                @Override // java.lang.Runnable
                public final void run() {
                    SearchEmoticonFragment.this.Hh();
                }
            });
            return;
        }
        MessageForPic Eh = Eh(str, str2);
        if (i3 == R.id.ino) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchEmoticonFragment", 2, "\u53d1\u9001\u7ed9\u597d\u53cb");
            }
            Intent Gh = Gh(Eh, 0, qQAppInterface, this.D);
            Gh.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getBaseActivity().getClass().getName());
            ForwardBaseOption.startForwardActivityForResult(super.getBaseActivity(), Gh, 1);
            Dh(Eh);
            ReportController.o(null, "dc00898", "", "", "0X8009EAA", "0X8009EAA", 0, 0, "", "", "", "");
            return;
        }
        if (i3 == R.id.f164036i1) {
            uRLDrawable.setTag(Eh);
            com.tencent.mobileqq.activity.aio.photo.c.e(this.D, qQAppInterface, uRLDrawable, Eh.frienduin, getBaseActivity().getResources().getDimensionPixelSize(R.dimen.title_bar_height), null, Eh.picExtraData);
            ReportController.o(null, "dc00898", "", "", "0X8009EAD", "0X8009EAD", 0, 0, "", "", "", "");
            EmoticonOperateReport.reportFavAddEmotionEvent(qQAppInterface, 5, Eh.md5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this.S, this.T.J);
            return;
        }
        Intent intent = new Intent(this.S, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.T.J);
        this.S.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    public View generateRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.c3j, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void initViewWithBusiness(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        super.initViewWithBusiness(view);
        this.H = (TextView) view.findViewById(R.id.k3);
        this.L = (TextView) view.findViewById(R.id.bh_);
        this.M = view.findViewById(R.id.bvp);
        this.N = (ImageView) view.findViewById(R.id.bh9);
        this.I = (ImageView) view.findViewById(R.id.f164116k2);
        ImageView imageView = (ImageView) view.findViewById(R.id.f164114k0);
        com.tencent.common.galleryactivity.l lVar = new com.tencent.common.galleryactivity.l();
        this.G = lVar;
        lVar.b(super.getBaseActivity(), imageView);
        this.P = getResources().getDrawable(R.drawable.f160231dr);
        float f16 = getResources().getDisplayMetrics().density;
        this.R = f16;
        this.Q = (int) (f16 * 6.0f);
        this.J = (Button) view.findViewById(R.id.ino);
        this.K = (Button) view.findViewById(R.id.f164036i1);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        SearchEmoticonWebBean searchEmoticonWebBean = (SearchEmoticonWebBean) this.S.getIntent().getParcelableExtra("SearchEmoticonWebBean");
        this.T = searchEmoticonWebBean;
        if (searchEmoticonWebBean == null) {
            SearchEmoticonWebBean searchEmoticonWebBean2 = new SearchEmoticonWebBean();
            this.T = searchEmoticonWebBean2;
            searchEmoticonWebBean2.C = 0;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.P;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mGifRoundCorner = this.Q;
        obtain.mPlayGifImage = true;
        URLDrawable drawable2 = URLDrawable.getDrawable(this.T.f205170e, obtain);
        this.I.setImageDrawable(drawable2);
        SearchEmoticonWebBean searchEmoticonWebBean3 = this.T;
        searchEmoticonWebBean3.I = AbsDownloader.getFilePath(searchEmoticonWebBean3.f205170e);
        if (this.T.C != 0) {
            this.M.setVisibility(0);
            this.M.setClickable(true);
            this.M.setOnTouchListener(new a());
            if (!TextUtils.isEmpty(this.T.D)) {
                drawable2 = URLDrawable.getDrawable(this.T.D, obtain);
            }
            int i3 = this.T.C;
            if (i3 != 1 && i3 != 3) {
                if (i3 == 2) {
                    this.N.setVisibility(8);
                    this.L.setText(this.T.H);
                    return;
                }
                return;
            }
            this.N.setImageDrawable(drawable2);
            this.L.setText(this.T.F);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 1) {
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.D.getString(R.string.hvn));
            Bundle bundle = new Bundle(intent.getExtras());
            Intent intent2 = new Intent();
            intent2.putExtras(bundle);
            if (super.sh() != null) {
                ForwardUtils.w(super.sh(), super.getBaseActivity(), this.D, intent2, ThreadManager.getUIHandler());
            }
            ReportController.o(null, "dc00898", "", "", "0X8009EAC", "0X8009EAC", 0, 0, "", "", "", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onAttach(activity);
            this.S = activity;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            final QQAppInterface sh5 = sh();
            if (sh5 == null) {
                QLog.w("SearchEmoticonFragment", 1, "error runtime");
            } else {
                final int id5 = view.getId();
                SearchEmoticonWebBean searchEmoticonWebBean = this.T;
                final String str = searchEmoticonWebBean.I;
                final String str2 = searchEmoticonWebBean.f205170e;
                final URLDrawable uRLDrawable = (URLDrawable) this.I.getDrawable();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emotionintegrate.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        SearchEmoticonFragment.this.Ih(str, str2, id5, sh5, uRLDrawable);
                    }
                }, 16, null, false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStart();
            ReportController.o(null, "dc00898", "", "", "0X8009EA9", "0X8009EA9", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void qh(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    protected void rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emotionintegrate.AIOEmotionBaseFragment
    public boolean vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
