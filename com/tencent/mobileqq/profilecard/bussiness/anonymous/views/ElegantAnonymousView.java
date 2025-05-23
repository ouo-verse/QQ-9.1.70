package com.tencent.mobileqq.profilecard.bussiness.anonymous.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.constant.AnonymousConstant;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ElegantAnonymousView extends AnonymousView {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    protected class ElegantAnonymousAdapter extends AnonymousView.AnonymousAdapter {
        static IPatchRedirector $redirector_;

        protected ElegantAnonymousAdapter() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ElegantAnonymousView.this);
            }
        }

        private void bindEventListener(AnonymousQuestion anonymousQuestion, AnonymousView.ListViewHolder listViewHolder) {
            View.OnClickListener onClickListener = new View.OnClickListener(anonymousQuestion, listViewHolder) { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.ElegantAnonymousView.ElegantAnonymousAdapter.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ AnonymousQuestion val$anonymousInfo;
                final /* synthetic */ AnonymousView.ListViewHolder val$listViewHolder;

                {
                    this.val$anonymousInfo = anonymousQuestion;
                    this.val$listViewHolder = listViewHolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ElegantAnonymousAdapter.this, anonymousQuestion, listViewHolder);
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
                            ElegantAnonymousView.this.clearRedPoint();
                            AnonymousQuestion anonymousQuestion2 = this.val$anonymousInfo;
                            int i16 = (int) anonymousQuestion2.mTotalPraiseCount;
                            if (anonymousQuestion2.mPraised) {
                                i3 = i16 - 1;
                            } else {
                                i3 = i16 + 1;
                            }
                            anonymousQuestion2.mTotalPraiseCount = i3;
                            AnonymousViewHelper.onClickLike(ElegantAnonymousView.this.appInterface, anonymousQuestion2);
                            AnonymousQuestion anonymousQuestion3 = this.val$anonymousInfo;
                            boolean z16 = !anonymousQuestion3.mPraised;
                            anonymousQuestion3.mPraised = z16;
                            ElegantAnonymousAdapter elegantAnonymousAdapter = ElegantAnonymousAdapter.this;
                            AnonymousView.ListViewHolder listViewHolder2 = this.val$listViewHolder;
                            elegantAnonymousAdapter.setLikeUi(z16, listViewHolder2.tvLike, listViewHolder2.ivLike, anonymousQuestion3.mTotalPraiseCount);
                        } else if (id5 != R.id.f59092rs && id5 != R.id.f58942rd) {
                            if (id5 == R.id.f59002rj) {
                                ElegantAnonymousView.this.clearRedPoint();
                                ProfileUtils.setViewClickInterval(view);
                                Activity activity = (Activity) ((ProfileContentTitleView) ElegantAnonymousView.this).mContext;
                                String str = ElegantAnonymousView.this.uin;
                                AnonymousQuestion anonymousQuestion4 = this.val$anonymousInfo;
                                AnonymousViewHelper.jumpToAnonymousDetail(activity, str, anonymousQuestion4.mId, "", 8, anonymousQuestion4.mQuestTime);
                                VideoReport.reportEvent("clck", view, null);
                            }
                        } else {
                            ElegantAnonymousView.this.clearRedPoint();
                            ProfileUtils.setViewClickInterval(view);
                            Activity activity2 = (Activity) ((ProfileContentTitleView) ElegantAnonymousView.this).mContext;
                            String str2 = ElegantAnonymousView.this.uin;
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

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter
        public void bindQuesDataToUI(AnonymousView.ListViewHolder listViewHolder, int i3) {
            Object valueOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) listViewHolder, i3);
                return;
            }
            AnonymousQuestion anonymousQuestion = ElegantAnonymousView.this.anonymousInfoList.get(i3);
            listViewHolder.tvQues.setText(new QQText("\u95ee\uff1a" + QzoneEmotionUtils.emCodesToQQcodes(anonymousQuestion.mQuest), 3, 16));
            listViewHolder.tvAnswer.setText(new QQText("\u7b54\uff1a" + QzoneEmotionUtils.emCodesToQQcodes(anonymousQuestion.mAnswer), 3, 16));
            listViewHolder.ivAnswer.setImageBitmap(ElegantAnonymousView.this.getFaceBitmap(anonymousQuestion.mOwnerUin));
            TextView textView = listViewHolder.tvBrowse;
            String string = ElegantAnonymousView.this.getContext().getString(R.string.f197564kc);
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
            int i16 = ElegantAnonymousView.this.randomHeadBgIndex + i3;
            int[] iArr = AnonymousConstant.HEAD_BG_COLOR;
            int length = i16 % iArr.length;
            listViewHolder.ivQuesHeadBg.clearColorFilter();
            listViewHolder.ivQuesHeadBg.setColorFilter(iArr[length]);
            setLikeUi(anonymousQuestion.mPraised, listViewHolder.tvLike, listViewHolder.ivLike, anonymousQuestion.mTotalPraiseCount);
            listViewHolder.tvComment.setText(ProfileUtils.formatPraiseNum((int) anonymousQuestion.mTotalCommentCount));
            bindEventListener(anonymousQuestion, listViewHolder);
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter, android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return ElegantAnonymousView.this.anonymousInfoList.size();
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter, android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            return ElegantAnonymousView.this.anonymousInfoList.get(i3).uiState;
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter, android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder instanceof AnonymousView.VisitorEmptyViewHolder) {
                AnonymousView.VisitorEmptyViewHolder visitorEmptyViewHolder = (AnonymousView.VisitorEmptyViewHolder) viewHolder;
                visitorEmptyViewHolder.button.setOnClickListener(ElegantAnonymousView.this);
                needShowEmptyView((URLImageView) visitorEmptyViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL);
            } else if (viewHolder instanceof AnonymousView.HostEmptyQuestionViewHolder) {
                AnonymousView.HostEmptyQuestionViewHolder hostEmptyQuestionViewHolder = (AnonymousView.HostEmptyQuestionViewHolder) viewHolder;
                hostEmptyQuestionViewHolder.button.setOnClickListener(ElegantAnonymousView.this);
                needShowEmptyView((URLImageView) hostEmptyQuestionViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL_TWO_LINE_TEXT);
            } else if (viewHolder instanceof AnonymousView.HostEmptyAnswerViewHolder) {
                AnonymousView.HostEmptyAnswerViewHolder hostEmptyAnswerViewHolder = (AnonymousView.HostEmptyAnswerViewHolder) viewHolder;
                hostEmptyAnswerViewHolder.button.setOnClickListener(ElegantAnonymousView.this);
                needShowEmptyView((URLImageView) hostEmptyAnswerViewHolder.imageView, AnonymousConstant.EMPTY_BACKGROUND_URL);
            } else if (viewHolder instanceof AnonymousView.VisitorAskQuestionViewHolder) {
                ((AnonymousView.VisitorAskQuestionViewHolder) viewHolder).viewAskQues.setOnClickListener(ElegantAnonymousView.this);
            } else if (viewHolder instanceof AnonymousView.HostShowTotalViewHolder) {
                ((AnonymousView.HostShowTotalViewHolder) viewHolder).viewTotal.setOnClickListener(ElegantAnonymousView.this);
            } else {
                bindQuesDataToUI((AnonymousView.ListViewHolder) viewHolder, i3);
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter, android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            if (4 == i3) {
                View inflate = LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.f168838h05, viewGroup, false);
                if (inflate != null) {
                    ElegantAnonymousView.this.initElementWithExposureClick((Button) inflate.findViewById(R.id.f59132rw), AnonymousView.DT_EM_CLICK_ASK_QUES_BTN);
                }
                return new AnonymousView.VisitorEmptyViewHolder(inflate);
            }
            if (5 == i3) {
                View inflate2 = LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.gwe, viewGroup, false);
                ElegantAnonymousView.this.initElementWithExposureClick(inflate2, AnonymousView.DT_EM_CLICK_ASK_QUES_BTN);
                return new AnonymousView.VisitorAskQuestionViewHolder(inflate2);
            }
            if (1 == i3) {
                return new AnonymousView.HostEmptyQuestionViewHolder(LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.f168834h01, viewGroup, false));
            }
            if (2 == i3) {
                return new AnonymousView.HostEmptyAnswerViewHolder(LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.f168833h00, viewGroup, false));
            }
            if (3 == i3) {
                return new AnonymousView.HostShowTotalViewHolder(LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.f168835h02, viewGroup, false));
            }
            View inflate3 = LayoutInflater.from(ElegantAnonymousView.this.getContext()).inflate(R.layout.gwd, viewGroup, false);
            inflate3.post(new Runnable(inflate3) { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.views.ElegantAnonymousView.ElegantAnonymousAdapter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ View val$view;

                {
                    this.val$view = inflate3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ElegantAnonymousAdapter.this, (Object) inflate3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ElegantAnonymousView.this.initElementWithExposureClick(this.val$view, AnonymousView.DT_EM_SPECIFIC_QUESTION);
                    }
                }
            });
            return new AnonymousView.ListViewHolder(inflate3);
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView.AnonymousAdapter
        public void setLikeUi(boolean z16, TextView textView, ImageView imageView, long j3) {
            ColorStateList colorStateList;
            String format;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), textView, imageView, Long.valueOf(j3));
                return;
            }
            Drawable drawable = ElegantAnonymousView.this.getContext().getResources().getDrawable(R.drawable.qui_like_secondary);
            if (z16) {
                drawable = ElegantAnonymousView.this.getContext().getResources().getDrawable(R.drawable.qui_like_brand);
            }
            if (QLog.isColorLevel()) {
                QLog.d(AnonymousView.TAG, 2, String.format("setLikeUi() mPraised=%b", Boolean.valueOf(z16)));
            }
            textView.setText(ProfileUtils.formatPraiseNum((int) j3));
            if (z16) {
                colorStateList = ElegantAnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_brand_standard, null);
            } else {
                colorStateList = ElegantAnonymousView.this.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary, null);
            }
            textView.setTextColor(colorStateList);
            if (j3 == 0) {
                format = "\u8d5e\uff0c\u6309\u94ae";
            } else {
                format = String.format("\u5df2\u70b9\u8d5e\uff0c\u70b9\u8d5e\u6570%d\uff0c\u6309\u94ae", Long.valueOf(j3));
            }
            imageView.setContentDescription(format);
            AccessibilityUtil.d(imageView, View.class.getName());
            imageView.setImageDrawable(drawable);
        }
    }

    public ElegantAnonymousView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView
    protected void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.recyclerView = new RecyclerView(getContext());
        this.anonymousAdapter = new ElegantAnonymousAdapter();
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.addItemDecoration(new AnonymousView.SpacesItemDecoration(Utils.n(12.0f, getContext().getResources()), 0));
        this.recyclerView.setAdapter(this.anonymousAdapter);
        this.recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        scrollEventListener();
        this.mRoot.setOnClickListener(this);
        setClickBgArea(true);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.views.AnonymousView, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setContentMarginBottom(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mContentContainer.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = ViewUtils.dpToPx(i3);
        }
    }

    public ElegantAnonymousView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
