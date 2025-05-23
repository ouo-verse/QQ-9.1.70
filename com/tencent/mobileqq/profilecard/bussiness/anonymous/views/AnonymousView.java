package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousRedPointUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.relation.common.config.toggle.c;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousView extends ProfileContentTitleView implements View.OnClickListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_ = null;
    public static final String DT_EM_CLICK_ASK_QUES_BTN = "em_profile_sendquestion";
    public static final String DT_EM_SPECIFIC_QUESTION = "em_profile_question_specific";
    static final String LIKE_DESCRIPTION = "\u8d5e\uff0c\u6309\u94ae";
    static final String LIKE_DETAIL_DESCRIPTION = "\u5df2\u70b9\u8d5e\uff0c\u70b9\u8d5e\u6570%d\uff0c\u6309\u94ae";
    public static final int NIGHT_MODE_MASK_COLOR;
    public static final String TAG = "AnonymousView";
    protected AnonymousAdapter anonymousAdapter;
    public List<AnonymousQuestion> anonymousInfoList;
    public AppInterface appInterface;
    private boolean isTheme;
    private IFaceDecoder mFaceDecoder;
    public int randomHeadBgIndex;
    public RecyclerView recyclerView;
    protected String uin;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class AnonymousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: protected */
        public AnonymousAdapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousView.this);
            }
        }

        private void bindEventListener(AnonymousQuestion anonymousQuestion, ListViewHolder listViewHolder) {
            View.OnClickListener onClickListener = new View.OnClickListener(anonymousQuestion, listViewHolder) { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AnonymousQuestion val$anonymousInfo;
                final /* synthetic */ ListViewHolder val$listViewHolder;

                {
                    this.val$anonymousInfo = anonymousQuestion;
                    this.val$listViewHolder = listViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousAdapter.this, anonymousQuestion, listViewHolder);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i3;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        int id5 = view.getId();
                        if (id5 == R.id.f58952re) {
                            AnonymousView.this.clearRedPoint();
                            AnonymousQuestion anonymousQuestion2 = this.val$anonymousInfo;
                            int i16 = (int) anonymousQuestion2.mTotalPraiseCount;
                            if (anonymousQuestion2.mPraised) {
                                i3 = i16 - 1;
                            } else {
                                i3 = i16 + 1;
                            }
                            anonymousQuestion2.mTotalPraiseCount = i3;
                            AnonymousViewHelper.onClickLike(AnonymousView.this.appInterface, anonymousQuestion2);
                            AnonymousQuestion anonymousQuestion3 = this.val$anonymousInfo;
                            boolean z16 = !anonymousQuestion3.mPraised;
                            anonymousQuestion3.mPraised = z16;
                            AnonymousAdapter anonymousAdapter = AnonymousAdapter.this;
                            ListViewHolder listViewHolder2 = this.val$listViewHolder;
                            anonymousAdapter.setLikeUi(z16, listViewHolder2.tvLike, listViewHolder2.ivLike, anonymousQuestion3.mTotalPraiseCount);
                        } else if (id5 != R.id.f59092rs && id5 != R.id.f58942rd) {
                            if (id5 == R.id.f59002rj) {
                                AnonymousView.this.clearRedPoint();
                                ProfileUtils.setViewClickInterval(view);
                                Activity activity = (Activity) ((ProfileContentTitleView) AnonymousView.this).mContext;
                                String str = AnonymousView.this.uin;
                                AnonymousQuestion anonymousQuestion4 = this.val$anonymousInfo;
                                AnonymousViewHelper.jumpToAnonymousDetail(activity, str, anonymousQuestion4.mId, "", 8, anonymousQuestion4.mQuestTime);
                                VideoReport.reportEvent("clck", view, null);
                            }
                        } else {
                            AnonymousView.this.clearRedPoint();
                            ProfileUtils.setViewClickInterval(view);
                            Activity activity2 = (Activity) ((ProfileContentTitleView) AnonymousView.this).mContext;
                            String str2 = AnonymousView.this.uin;
                            AnonymousQuestion anonymousQuestion5 = this.val$anonymousInfo;
                            AnonymousViewHelper.jumpToComment(activity2, str2, anonymousQuestion5.mId, anonymousQuestion5.mQuestTime);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            listViewHolder.tvLike.setClickable(false);
            listViewHolder.ivLike.setOnClickListener(onClickListener);
            listViewHolder.tvComment.setOnClickListener(onClickListener);
            listViewHolder.ivComment.setOnClickListener(onClickListener);
            listViewHolder.tvBrowse.setOnClickListener(onClickListener);
            listViewHolder.ivBrowser.setClickable(false);
            TextView textView = listViewHolder.tvComment;
            ba.a aVar = ba.f77070d;
            textView.setOnTouchListener(aVar);
            listViewHolder.ivComment.setOnTouchListener(aVar);
            listViewHolder.root.setOnClickListener(onClickListener);
        }

        private boolean needShowEmptyView(URLImageView uRLImageView, String str) {
            if (uRLImageView != null && str != null) {
                uRLImageView.setImageURL(str);
                if (QQTheme.isNowThemeIsNight()) {
                    uRLImageView.setColorFilter(AnonymousView.NIGHT_MODE_MASK_COLOR, PorterDuff.Mode.SRC_ATOP);
                    return true;
                }
                uRLImageView.setColorFilter(0);
                return true;
            }
            return true;
        }

        public void bindQuesDataToUI(ListViewHolder listViewHolder, int i3) {
            Object valueOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) listViewHolder, i3);
                return;
            }
            AnonymousQuestion anonymousQuestion = AnonymousView.this.anonymousInfoList.get(i3);
            listViewHolder.tvQues.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(anonymousQuestion.mQuest), 3, 16));
            listViewHolder.tvAnswer.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(anonymousQuestion.mAnswer), 3, 16));
            listViewHolder.ivAnswer.setImageBitmap(AnonymousView.this.getFaceBitmap(anonymousQuestion.mOwnerUin));
            TextView textView = listViewHolder.tvBrowse;
            String string = AnonymousView.this.getContext().getString(R.string.f197564kc);
            Object[] objArr = new Object[1];
            long j3 = anonymousQuestion.mTotalViewCount;
            if (j3 > 0) {
                valueOf = ProfileUtils.formatPraiseNum((int) j3);
            } else {
                valueOf = Long.valueOf(j3);
            }
            objArr[0] = valueOf;
            textView.setText(String.format(string, objArr));
            listViewHolder.ivQues.setImageResource(R.drawable.nfy);
            listViewHolder.ivQuesHeadBg.setImageResource(R.drawable.ktp);
            listViewHolder.ivQuesHeadCircle.setImageResource(R.drawable.ktr);
            listViewHolder.ivAnswerHeadCircle.setImageResource(R.drawable.kti);
            int i16 = AnonymousView.this.randomHeadBgIndex + i3;
            int[] iArr = AnonymousConstant.HEAD_BG_COLOR;
            int length = i16 % iArr.length;
            listViewHolder.ivQuesHeadBg.clearColorFilter();
            listViewHolder.ivQuesHeadBg.setColorFilter(iArr[length]);
            setLikeUi(anonymousQuestion.mPraised, listViewHolder.tvLike, listViewHolder.ivLike, anonymousQuestion.mTotalPraiseCount);
            listViewHolder.tvComment.setText(ProfileUtils.formatPraiseNum((int) anonymousQuestion.mTotalCommentCount));
            bindEventListener(anonymousQuestion, listViewHolder);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return AnonymousView.this.anonymousInfoList.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            return AnonymousView.this.anonymousInfoList.get(i3).uiState;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder instanceof VisitorEmptyViewHolder) {
                VisitorEmptyViewHolder visitorEmptyViewHolder = (VisitorEmptyViewHolder) viewHolder;
                visitorEmptyViewHolder.button.setOnClickListener(AnonymousView.this);
                needShowEmptyView((URLImageView) visitorEmptyViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL);
            } else if (viewHolder instanceof HostEmptyQuestionViewHolder) {
                HostEmptyQuestionViewHolder hostEmptyQuestionViewHolder = (HostEmptyQuestionViewHolder) viewHolder;
                hostEmptyQuestionViewHolder.button.setOnClickListener(AnonymousView.this);
                needShowEmptyView((URLImageView) hostEmptyQuestionViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL_TWO_LINE_TEXT);
            } else if (viewHolder instanceof HostEmptyAnswerViewHolder) {
                HostEmptyAnswerViewHolder hostEmptyAnswerViewHolder = (HostEmptyAnswerViewHolder) viewHolder;
                hostEmptyAnswerViewHolder.button.setOnClickListener(AnonymousView.this);
                needShowEmptyView((URLImageView) hostEmptyAnswerViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL);
            } else if (viewHolder instanceof VisitorAskQuestionViewHolder) {
                ((VisitorAskQuestionViewHolder) viewHolder).viewAskQues.setOnClickListener(AnonymousView.this);
            } else if (viewHolder instanceof HostShowTotalViewHolder) {
                ((HostShowTotalViewHolder) viewHolder).viewTotal.setOnClickListener(AnonymousView.this);
            } else {
                bindQuesDataToUI((ListViewHolder) viewHolder, i3);
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            if (4 == i3) {
                View inflate = LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168838h05, viewGroup, false);
                if (inflate != null) {
                    AnonymousView.this.initElementWithExposureClick((Button) inflate.findViewById(R.id.f59132rw), AnonymousView.DT_EM_CLICK_ASK_QUES_BTN);
                }
                return new VisitorEmptyViewHolder(inflate);
            }
            if (5 == i3) {
                View inflate2 = LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168837h04, viewGroup, false);
                AnonymousView.this.initElementWithExposureClick(inflate2, AnonymousView.DT_EM_CLICK_ASK_QUES_BTN);
                return new VisitorAskQuestionViewHolder(inflate2);
            }
            if (1 == i3) {
                return new HostEmptyQuestionViewHolder(LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168834h01, viewGroup, false));
            }
            if (2 == i3) {
                return new HostEmptyAnswerViewHolder(LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168833h00, viewGroup, false));
            }
            if (3 == i3) {
                return new HostShowTotalViewHolder(LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168835h02, viewGroup, false));
            }
            View inflate3 = LayoutInflater.from(AnonymousView.this.getContext()).inflate(R.layout.f168836h03, viewGroup, false);
            inflate3.post(new Runnable(inflate3) { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View val$view;

                {
                    this.val$view = inflate3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousAdapter.this, (Object) inflate3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AnonymousView.this.initElementWithExposureClick(this.val$view, AnonymousView.DT_EM_SPECIFIC_QUESTION);
                    }
                }
            });
            return new ListViewHolder(inflate3);
        }

        public void setLikeUi(boolean z16, TextView textView, ImageView imageView, long j3) {
            ColorStateList colorStateList;
            ColorStateList colorStateList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), textView, imageView, Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AnonymousView.TAG, 2, String.format("setLikeUi() mPraised=%b", Boolean.valueOf(z16)));
            }
            textView.setText(ProfileUtils.formatPraiseNum((int) j3));
            if (z16) {
                colorStateList = AnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_brand_standard, null);
            } else {
                colorStateList = AnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary, null);
            }
            textView.setTextColor(colorStateList);
            imageView.setImageDrawable(cn.f(AnonymousView.this.getContext().getResources().getDrawable(R.drawable.qui_like, null)));
            if (z16) {
                colorStateList2 = AnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_brand_standard, null);
            } else {
                colorStateList2 = AnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_icon_secondary, null);
            }
            imageView.setImageTintList(colorStateList2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected static class HostEmptyAnswerViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        Button button;
        ImageView imageView;

        public HostEmptyAnswerViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.button = (Button) view.findViewById(R.id.f58882r8);
                this.imageView = (ImageView) view.findViewById(R.id.f58902r_);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected static class HostEmptyQuestionViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        Button button;
        ImageView imageView;

        public HostEmptyQuestionViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.button = (Button) view.findViewById(R.id.f58892r9);
                this.imageView = (ImageView) view.findViewById(R.id.f58902r_);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected static class HostShowTotalViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: ll, reason: collision with root package name */
        View f260666ll;
        View viewTotal;

        public HostShowTotalViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.viewTotal = view.findViewById(R.id.f58872r7);
                this.f260666ll = view.findViewById(R.id.f58872r7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        ImageView ivAnswer;
        ImageView ivAnswerHeadCircle;
        ImageView ivBrowser;
        ImageView ivComment;
        ImageView ivLike;
        ImageView ivQues;
        ImageView ivQuesHeadBg;
        ImageView ivQuesHeadCircle;

        /* renamed from: ll, reason: collision with root package name */
        ViewGroup f260667ll;

        /* renamed from: rl, reason: collision with root package name */
        ViewGroup f260668rl;
        ViewGroup root;
        TextView tvAnswer;
        TextView tvBrowse;
        TextView tvComment;
        TextView tvLike;
        TextView tvQues;

        public ListViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.root = (ViewGroup) view.findViewById(R.id.f59002rj);
            this.f260667ll = (ViewGroup) view.findViewById(R.id.f58992ri);
            this.ivQuesHeadBg = (ImageView) view.findViewById(R.id.f58972rg);
            this.ivQues = (ImageView) view.findViewById(R.id.f58962rf);
            this.tvQues = (TextView) view.findViewById(R.id.f59112ru);
            this.ivQuesHeadCircle = (ImageView) view.findViewById(R.id.f58982rh);
            this.ivAnswer = (ImageView) view.findViewById(R.id.f58912ra);
            this.ivAnswerHeadCircle = (ImageView) view.findViewById(R.id.f58922rb);
            this.tvAnswer = (TextView) view.findViewById(R.id.f59072rq);
            this.ivBrowser = (ImageView) view.findViewById(R.id.f58932rc);
            this.tvBrowse = (TextView) view.findViewById(R.id.f59082rr);
            this.tvLike = (TextView) view.findViewById(R.id.f59102rt);
            this.ivLike = (ImageView) view.findViewById(R.id.f58952re);
            this.tvComment = (TextView) view.findViewById(R.id.f59092rs);
            this.ivComment = (ImageView) view.findViewById(R.id.f58942rd);
            this.f260668rl = (ViewGroup) view.findViewById(R.id.f59012rk);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;
        private int firstItemLeftSpace;
        private int space;

        public SpacesItemDecoration(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.space = i3;
                this.firstItemLeftSpace = i16;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
            } else if (recyclerView.getChildPosition(view) == 0) {
                rect.left = this.firstItemLeftSpace;
            } else {
                rect.left = this.space;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected static class VisitorAskQuestionViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: ll, reason: collision with root package name */
        View f260669ll;
        View viewAskQues;

        public VisitorAskQuestionViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.viewAskQues = view.findViewById(R.id.f59122rv);
            View findViewById = view.findViewById(R.id.f59122rv);
            this.f260669ll = findViewById;
            AccessibilityUtil.d(findViewById, Button.class.getName());
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected static class VisitorEmptyViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        Button button;
        ImageView imageView;

        public VisitorEmptyViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.button = (Button) view.findViewById(R.id.f59132rw);
                this.imageView = (ImageView) view.findViewById(R.id.f58902r_);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            NIGHT_MODE_MASK_COLOR = Color.parseColor("#A6000000");
        }
    }

    public AnonymousView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.anonymousInfoList = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearRedPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.mTitleText.getCompoundDrawables() != null) {
            this.mTitleText.setCompoundDrawables(null, null, null, null);
            AnonymousRedPointUtils.cleanProfileRedPointGuide(this.appInterface);
        }
    }

    public IFaceDecoder createFaceDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IFaceDecoder) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((IQQAvatarService) this.appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.appInterface);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mFaceDecoder.setDecodeTaskCompletionListener(null);
        this.mFaceDecoder.destory();
        if (!c.f364700m.g(false)) {
            this.recyclerView.addOnScrollListener(null);
            this.recyclerView.addOnItemTouchListener(null);
        }
        this.anonymousInfoList.clear();
        this.appInterface = null;
    }

    public Bitmap getFaceBitmap(long j3) {
        Bitmap bitmapFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, j3);
        }
        try {
            bitmapFromCache = this.mFaceDecoder.getBitmapFromCache(1, String.valueOf(j3));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (!this.mFaceDecoder.isPausing()) {
            this.mFaceDecoder.requestDecodeFace(String.valueOf(j3), 200, true);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.init();
            initViews();
        }
    }

    public void initData(AppInterface appInterface, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, Boolean.valueOf(z16), str);
            return;
        }
        this.appInterface = appInterface;
        this.isTheme = z16;
        this.uin = str;
        IFaceDecoder createFaceDecoder = createFaceDecoder();
        this.mFaceDecoder = createFaceDecoder;
        createFaceDecoder.setDecodeTaskCompletionListener(this);
        this.randomHeadBgIndex = (int) (Math.random() * AnonymousConstant.HEAD_BG_COLOR.length);
    }

    public void initElementWithExposureClick(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) str);
        } else {
            if (view == null) {
                return;
            }
            VideoReport.setElementId(view, str);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
    }

    protected void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.recyclerView = new RecyclerView(getContext());
        this.anonymousAdapter = new AnonymousAdapter();
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.addItemDecoration(new SpacesItemDecoration(Utils.n(12.0f, getContext().getResources()), 0));
        this.recyclerView.setAdapter(this.anonymousAdapter);
        scrollEventListener();
        this.mTitleContainer.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.title_container && id5 != R.id.root_layout) {
                if (id5 == R.id.f58872r7) {
                    clearRedPoint();
                    AnonymousViewHelper.jumpToQuestionListAndAnswer((Activity) this.mContext, this.uin, 2);
                    ReportController.o(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
                } else if (id5 == R.id.f58892r9) {
                    clearRedPoint();
                    AnonymousViewHelper.jumpToReqFriendAskQuestion((Activity) this.mContext);
                    ReportController.o(null, "dc00898", "", "", "0X800B46D", "0X800B46D", 0, 0, "", "", "", "");
                } else if (id5 == R.id.f58882r8) {
                    clearRedPoint();
                    AnonymousViewHelper.jumpToQuestionListAndAnswer((Activity) this.mContext, this.uin, 3);
                    ReportController.o(null, "dc00898", "", this.uin, "0X800B473", "0X800B473", 0, 0, "", "", "", "");
                } else if (id5 == R.id.f59132rw || id5 == R.id.f59122rv) {
                    clearRedPoint();
                    AnonymousViewHelper.jumpToAskQuestion((Activity) this.mContext, this.uin, 6);
                    ReportController.o(null, "dc00898", "", "", "0X800B472", "0X800B472", 0, 0, "", "", "", "");
                    VideoReport.reportEvent("clck", view, null);
                }
            } else {
                clearRedPoint();
                AnonymousViewHelper.jumpToQuestionListAndAnswer((Activity) this.mContext, this.uin, 1);
                ReportController.o(null, "dc00898", "", "", "0X800B46C", "0X800B46C", 0, 0, "", "", "", "");
            }
            VideoReport.reportEvent("clck", this, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        int childCount = this.recyclerView.getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            RecyclerView.ViewHolder childViewHolder = this.recyclerView.getChildViewHolder(this.recyclerView.getChildAt(i17));
            if (childViewHolder instanceof ListViewHolder) {
                int adapterPosition = childViewHolder.getAdapterPosition();
                if (adapterPosition >= 0 && adapterPosition < this.anonymousInfoList.size()) {
                    AnonymousQuestion anonymousQuestion = this.anonymousInfoList.get(adapterPosition);
                    if (anonymousQuestion != null && anonymousQuestion.mOwnerUin == Long.parseLong(str) && bitmap != null) {
                        ((ListViewHolder) childViewHolder).ivAnswer.setImageBitmap(bitmap);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void scrollEventListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.1
                static IPatchRedirector $redirector_;
                private boolean mCheckInterceptTouch;
                private float mLastTouchDownX;
                private float mLastTouchDownY;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousView.this);
                    }
                }

                private boolean moveHorizontal(MotionEvent motionEvent) {
                    if (Math.abs(this.mLastTouchDownX - motionEvent.getX()) > Math.abs(this.mLastTouchDownY - motionEvent.getY())) {
                        return true;
                    }
                    return false;
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
                
                    if (r0 != 3) goto L27;
                 */
                @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, (Object) motionEvent)).booleanValue();
                    }
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (!this.mCheckInterceptTouch) {
                                    this.mCheckInterceptTouch = true;
                                    if (moveHorizontal(motionEvent) && recyclerView.getParent() != null) {
                                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                        if (recyclerView.getParent() != null) {
                            recyclerView.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        this.mLastTouchDownX = motionEvent.getX();
                        this.mLastTouchDownY = motionEvent.getY();
                        this.mCheckInterceptTouch = false;
                    }
                    return false;
                }

                @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
                public void onRequestDisallowInterceptTouchEvent(boolean z16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
                public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) recyclerView, (Object) motionEvent);
                    }
                }
            });
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousView.this);
                    }
                }

                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                        return;
                    }
                    if (i3 != 0 && i3 != 1) {
                        AnonymousView.this.mFaceDecoder.cancelPendingRequests();
                        AnonymousView.this.mFaceDecoder.pause();
                    } else if (AnonymousView.this.mFaceDecoder.isPausing()) {
                        AnonymousView.this.mFaceDecoder.resume();
                    }
                }
            });
        }
    }

    public void show(List<AnonymousQuestion> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        removeContentViews();
        addContentView(this.recyclerView);
        this.anonymousInfoList.clear();
        this.anonymousInfoList.addAll(list);
        this.anonymousAdapter.notifyDataSetChanged();
    }

    public AnonymousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.anonymousInfoList = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
