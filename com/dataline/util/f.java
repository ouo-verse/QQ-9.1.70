package com.dataline.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f extends DatalineSessionAdapter {
    private View.OnClickListener K;
    private View.OnClickListener L;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DataLineMsgSet d16;
            long j3;
            EventCollector.getInstance().onViewClickedBefore(view);
            h hVar = (h) view.getTag();
            if (hVar != null && (d16 = hVar.d()) != null) {
                if (d16.getFirstItem() != null) {
                    j3 = d16.getFirstItem().sessionid;
                } else {
                    QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop send but no sessionid");
                    j3 = 0;
                }
                d16.setPaused(true);
                ((DataLineHandler) f.this.E.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).j3(d16.getGroupId(), j3, false);
                f.this.P(hVar, d16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DataLineMsgSet d16;
            long j3;
            EventCollector.getInstance().onViewClickedBefore(view);
            h hVar = (h) view.getTag();
            if (hVar != null && (d16 = hVar.d()) != null) {
                if (d16.getFirstItem() != null) {
                    j3 = d16.getFirstItem().sessionid;
                } else {
                    QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "stop recv but no sessionid");
                    j3 = 0;
                }
                d16.setPaused(true);
                ((DataLineHandler) f.this.E.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).j3(d16.getGroupId(), j3, false);
                f.this.P(hVar, d16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(Context context, DataLineMsgSetList dataLineMsgSetList, LiteActivity liteActivity, QQAppInterface qQAppInterface) {
        super(context, dataLineMsgSetList, liteActivity, qQAppInterface);
        this.K = new a();
        this.L = new b();
    }

    private void K(DataLineMsgRecord dataLineMsgRecord, h hVar) {
        if (dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.issuc && !O(dataLineMsgRecord)) {
            CircleFileStateView circleFileStateView = hVar.f().f32432b;
            CircleFileStateView circleFileStateView2 = hVar.f().f32433c;
            circleFileStateView.setVisibility(0);
            circleFileStateView.setState(2);
            circleFileStateView2.setVisibility(8);
            if (!dataLineMsgRecord.isSendFromLocal()) {
                hVar.f().f32436f.setVisibility(8);
            }
            circleFileStateView.setTag(hVar);
            circleFileStateView2.setTag(hVar);
            circleFileStateView.setOnClickListener(this.D.W0);
            circleFileStateView2.setOnClickListener(this.L);
        }
    }

    private void L(View view, h hVar) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.lz5);
        CircleFileStateView circleFileStateView = new CircleFileStateView(this.C);
        circleFileStateView.setId(R.id.lcq);
        circleFileStateView.setProgressRingWidth(0.0f);
        circleFileStateView.setCenterBgColor(-1);
        circleFileStateView.setState(2);
        hVar.f().f32432b = circleFileStateView;
        int f16 = BaseAIOUtils.f(24.0f, this.C.getResources());
        relativeLayout.addView(circleFileStateView, new RelativeLayout.LayoutParams(f16, f16));
        circleFileStateView.setVisibility(4);
        circleFileStateView.setContentDescription(this.C.getString(R.string.b7b));
        CircleFileStateView circleFileStateView2 = new CircleFileStateView(this.C);
        circleFileStateView2.setId(R.id.lcr);
        circleFileStateView2.setProgressRingWidth(0.0f);
        circleFileStateView2.setCenterBgColor(-1);
        circleFileStateView2.setState(1);
        hVar.f().f32433c = circleFileStateView2;
        relativeLayout.addView(circleFileStateView2, new RelativeLayout.LayoutParams(f16, f16));
        circleFileStateView2.setVisibility(4);
        circleFileStateView2.setContentDescription(this.C.getString(R.string.ba7));
    }

    private void M(View view, h hVar) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.lz5);
        ImageView imageView = new ImageView(this.C);
        imageView.setImageResource(R.drawable.gxn);
        imageView.setId(R.id.lcu);
        hVar.f().f32440j = imageView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(imageView, layoutParams);
        imageView.setVisibility(8);
        imageView.setContentDescription(this.C.getString(R.string.b5j));
        ImageView imageView2 = new ImageView(this.C);
        imageView2.setImageResource(R.drawable.f160226dl);
        imageView2.setId(R.id.lcs);
        hVar.f().f32441k = imageView2;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView2, layoutParams2);
        imageView2.setVisibility(8);
        imageView2.setContentDescription(this.C.getString(R.string.bf8));
    }

    private void N(DataLineMsgSet dataLineMsgSet, h hVar) {
        int i3;
        if (dataLineMsgSet.isSendFromLocal()) {
            i3 = R.drawable.b47;
        } else {
            i3 = R.drawable.f162446b42;
        }
        hVar.f32392i.setBackgroundResource(i3);
    }

    private boolean O(DataLineMsgRecord dataLineMsgRecord) {
        if (!TextUtils.isEmpty(dataLineMsgRecord.path) && q.p(dataLineMsgRecord.path)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(h hVar, DataLineMsgSet dataLineMsgSet) {
        DataLineMsgRecord firstItem;
        if (hVar == null || dataLineMsgSet == null || (firstItem = dataLineMsgSet.getFirstItem()) == null) {
            return;
        }
        String str = firstItem.filename;
        long j3 = firstItem.filesize;
        if (hVar.f().f32439i != null) {
            Q(hVar.f().f32439i, firstItem);
        } else {
            QLog.w("DatalineSessionAdapterUseNewFileBubble", 1, "refreshNewFileBubbleViewData fileIcon is null !");
        }
        if (hVar.f().f32434d != null) {
            hVar.f().f32434d.setText(str);
        } else {
            QLog.w("DatalineSessionAdapterUseNewFileBubble", 1, "refreshNewFileBubbleViewData fileNameTv is null !");
        }
        if (hVar.f().f32435e != null) {
            hVar.f().f32435e.setText(q.h(j3, this.C.getResources().getDisplayMetrics().densityDpi));
        } else {
            QLog.w("DatalineSessionAdapterUseNewFileBubble", 1, "refreshNewFileBubbleViewData fileDescTv is null !");
        }
        R(firstItem, hVar);
        S(firstItem, hVar);
        if (firstItem.isSendFromLocal()) {
            ImageView imageView = hVar.f().f32440j;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = hVar.f().f32441k;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            CircleFileStateView circleFileStateView = hVar.f().f32432b;
            if (circleFileStateView != null) {
                circleFileStateView.setVisibility(8);
            }
            CircleFileStateView circleFileStateView2 = hVar.f().f32433c;
            if (circleFileStateView2 != null) {
                circleFileStateView2.setVisibility(8);
            }
            if (!firstItem.bIsSended && firstItem.nOpType != 1) {
                U(firstItem, hVar);
            } else {
                T(firstItem, hVar);
            }
        } else {
            T(firstItem, hVar);
        }
        K(firstItem, hVar);
    }

    private void R(DataLineMsgRecord dataLineMsgRecord, h hVar) {
        float f16 = dataLineMsgRecord.progress;
        if (f16 != 1.0f && dataLineMsgRecord.issuc) {
            long j3 = dataLineMsgRecord.fileMsgStatus;
            if (j3 != 1 && j3 != 2 && j3 != 3) {
                int i3 = (int) (f16 * 100.0f);
                hVar.f().f32437g.setVisibility(0);
                hVar.f().f32437g.setProgress(i3);
                hVar.f().f32437g.setContentDescription(this.C.getString(R.string.ip7) + i3);
                int f17 = BaseAIOUtils.f(14.0f, this.C.getResources());
                int f18 = BaseAIOUtils.f(18.0f, this.C.getResources());
                if (dataLineMsgRecord.isSendFromLocal()) {
                    hVar.f().f32438h.setPadding(f17, f17, f18, 0);
                    return;
                } else {
                    hVar.f().f32438h.setPadding(f18, f17, f17, 0);
                    return;
                }
            }
        }
        hVar.f().f32437g.setVisibility(8);
        int f19 = BaseAIOUtils.f(14.0f, this.C.getResources());
        int f26 = BaseAIOUtils.f(18.0f, this.C.getResources());
        if (dataLineMsgRecord.isSendFromLocal()) {
            hVar.f().f32438h.setPadding(f19, f19, f26, f19);
        } else {
            hVar.f().f32438h.setPadding(f26, f19, f19, f19);
        }
    }

    private void S(DataLineMsgRecord dataLineMsgRecord, h hVar) {
        String str = "";
        if (dataLineMsgRecord.isSendFromLocal()) {
            if (dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.issuc) {
                str = " / " + this.C.getString(R.string.b7g);
            } else {
                long j3 = dataLineMsgRecord.fileMsgStatus;
                if (j3 == 3) {
                    str = " / " + this.C.getString(R.string.f1626120w);
                } else if (j3 == 2) {
                    str = " / " + this.C.getString(R.string.c4q);
                } else if (!dataLineMsgRecord.bIsTransfering && !dataLineMsgRecord.issuc) {
                    if (!dataLineMsgRecord.bIsSended && dataLineMsgRecord.nOpType != 1) {
                        str = " / " + this.C.getString(R.string.b7f);
                    } else {
                        str = " / " + this.C.getString(R.string.b7e);
                    }
                }
            }
        } else if (dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.issuc) {
            str = " / " + this.C.getString(R.string.b7a);
        } else {
            long j16 = dataLineMsgRecord.fileMsgStatus;
            if (j16 == 3) {
                str = " / " + this.C.getString(R.string.f1626120w);
            } else if (j16 == 2) {
                str = " / " + this.C.getString(R.string.c4q);
            } else if (!dataLineMsgRecord.bIsTransfering && !dataLineMsgRecord.issuc) {
                str = " / " + this.C.getString(R.string.b7e);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            hVar.f().f32436f.setVisibility(0);
            hVar.f().f32436f.setText(str);
        } else {
            hVar.f().f32436f.setVisibility(8);
        }
    }

    private void T(DataLineMsgRecord dataLineMsgRecord, h hVar) {
        CircleFileStateView circleFileStateView = hVar.f().f32432b;
        CircleFileStateView circleFileStateView2 = hVar.f().f32433c;
        if (circleFileStateView != null && circleFileStateView2 != null) {
            if (dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.issuc) {
                circleFileStateView.setVisibility(8);
                circleFileStateView2.setVisibility(8);
            } else {
                long j3 = dataLineMsgRecord.fileMsgStatus;
                if (j3 == 3) {
                    circleFileStateView.setVisibility(8);
                    circleFileStateView2.setVisibility(8);
                } else if (j3 == 2) {
                    circleFileStateView.setVisibility(0);
                    circleFileStateView.setState(2);
                    circleFileStateView2.setVisibility(8);
                } else if (j3 == 1) {
                    circleFileStateView.setVisibility(0);
                    circleFileStateView.setState(2);
                    circleFileStateView2.setVisibility(8);
                } else if (dataLineMsgRecord.bIsTransfering) {
                    circleFileStateView.setVisibility(8);
                    circleFileStateView2.setVisibility(0);
                } else if (!dataLineMsgRecord.issuc) {
                    circleFileStateView.setVisibility(0);
                    circleFileStateView.setState(2);
                    circleFileStateView2.setVisibility(8);
                } else {
                    circleFileStateView.setVisibility(8);
                    circleFileStateView2.setVisibility(0);
                }
            }
            circleFileStateView.setTag(hVar);
            circleFileStateView2.setTag(hVar);
            circleFileStateView.setOnClickListener(this.D.W0);
            circleFileStateView2.setOnClickListener(this.L);
        }
    }

    private void U(DataLineMsgRecord dataLineMsgRecord, h hVar) {
        ImageView imageView = hVar.f().f32440j;
        ImageView imageView2 = hVar.f().f32441k;
        if (imageView != null && imageView2 != null) {
            if (dataLineMsgRecord.progress == 1.0f && dataLineMsgRecord.issuc) {
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
            } else {
                long j3 = dataLineMsgRecord.fileMsgStatus;
                if (j3 == 3) {
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                } else if (j3 == 2) {
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else if (dataLineMsgRecord.bIsTransfering) {
                    imageView.setVisibility(0);
                    imageView2.setVisibility(8);
                } else if (!dataLineMsgRecord.issuc) {
                    imageView.setVisibility(8);
                    imageView2.setVisibility(0);
                } else {
                    imageView.setVisibility(0);
                    imageView2.setVisibility(8);
                }
            }
            imageView.setTag(hVar);
            imageView2.setTag(hVar);
            imageView.setOnClickListener(this.K);
            imageView2.setOnClickListener(this.D.V0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.dataline.util.DatalineSessionAdapter
    public void D(DataLineMsgRecord dataLineMsgRecord, View view, float f16) {
        super.D(dataLineMsgRecord, view, f16);
        if (dataLineMsgRecord != null && view != null) {
            float f17 = dataLineMsgRecord.progress;
            if (f16 < f17) {
                f16 = f17;
            }
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.aug);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                progressBar.setProgress((int) (f16 * 100.0f));
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.c_t);
            if (relativeLayout != null) {
                int f18 = BaseAIOUtils.f(14.0f, this.C.getResources());
                int f19 = BaseAIOUtils.f(18.0f, this.C.getResources());
                if (dataLineMsgRecord.isSendFromLocal()) {
                    relativeLayout.setPadding(f18, f18, f19, 0);
                } else {
                    relativeLayout.setPadding(f19, f18, f18, 0);
                }
            }
        }
    }

    @Override // com.dataline.util.DatalineSessionAdapter
    protected void F(int i3, h hVar, DataLineMsgSet dataLineMsgSet) {
        if (!hVar.n()) {
            QLog.e("DatalineSessionAdapterUseNewFileBubble", 1, "[updateExtraBubbleView] DatalineSessionAdapterUseNewFileBubble update method was called before init method!!");
            return;
        }
        P(hVar, dataLineMsgSet);
        N(dataLineMsgSet, hVar);
        if (ThemeUtil.isInNightMode(this.E)) {
            Object tag = this.D.f32038a0.getTag(R.id.f163834n);
            if (tag instanceof ChatBackgroundDrawable) {
                hVar.l().setTextColor(ColorStateList.valueOf(t.h(((ChatBackgroundDrawable) tag).getBitmap())));
            }
        }
        if (d(dataLineMsgSet.getMsgId())) {
            CharSequence d16 = en.d(this.C, 3, dataLineMsgSet.getTime() * 1000);
            hVar.l().setVisibility(0);
            hVar.l().setText(d16);
            return;
        }
        hVar.l().setVisibility(8);
    }

    void Q(AsyncImageView asyncImageView, DataLineMsgRecord dataLineMsgRecord) {
        String j3 = q.j(dataLineMsgRecord.filename);
        if (TextUtils.isEmpty(j3)) {
            asyncImageView.setImageResource(R.drawable.f161608ea0);
            return;
        }
        asyncImageView.setDefaultImage(FileManagerUtil.getFileIconResId(j3));
        if (FileManagerUtil.getFileType(j3) == 0) {
            String str = dataLineMsgRecord.filename;
            if (FileUtils.fileExistsAndNotEmpty(dataLineMsgRecord.thumbPath)) {
                str = dataLineMsgRecord.thumbPath;
            } else if (FileUtils.fileExistsAndNotEmpty(dataLineMsgRecord.path)) {
                str = dataLineMsgRecord.path;
            }
            asyncImageView.setAsyncImage(str);
            return;
        }
        int fileIconResId = FileManagerUtil.getFileIconResId(j3);
        if (fileIconResId != 0) {
            asyncImageView.setImageResource(fileIconResId);
        }
    }

    @Override // com.dataline.util.DatalineSessionAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        int itemViewType = super.getItemViewType(i3);
        if (itemViewType == 10) {
            return 18;
        }
        if (itemViewType == 3) {
            return 17;
        }
        return itemViewType;
    }

    @Override // com.dataline.util.DatalineSessionAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return super.getViewTypeCount() + 2;
    }

    @Override // com.dataline.util.DatalineSessionAdapter
    protected View k(int i3, h hVar, DataLineMsgSet dataLineMsgSet) {
        View inflate;
        if (i3 == 17) {
            inflate = this.f32339m.inflate(R.layout.c7u, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
            Drawable drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
            int devTypeBySet = DataLineMsgRecord.getDevTypeBySet(dataLineMsgSet);
            if (devTypeBySet == 0) {
                drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent);
            } else if (devTypeBySet == 1) {
                drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_ipad_recent);
            } else if (devTypeBySet == 2) {
                drawable = this.D.getResources().getDrawable(R.drawable.qfile_dataline_user_aio);
            }
            imageView.setImageDrawable(drawable);
        } else {
            inflate = this.f32339m.inflate(R.layout.c7v, (ViewGroup) null);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.f1j);
        hVar.f32392i = relativeLayout;
        relativeLayout.setTag(hVar);
        hVar.f32392i.setClickable(true);
        hVar.f32392i.setLongClickable(true);
        hVar.f32392i.setOnClickListener(this.J);
        hVar.f32392i.setOnLongClickListener(this.D.f32039a1);
        hVar.f32392i.setOnTouchListener(this.D.f32041b1);
        hVar.f32392i.setAddStatesFromChildren(true);
        hVar.u((TextView) inflate.findViewById(R.id.bdp));
        int f16 = BaseAIOUtils.f(14.0f, this.C.getResources());
        int f17 = BaseAIOUtils.f(6.0f, this.C.getResources());
        RelativeLayout relativeLayout2 = new RelativeLayout(this.C);
        relativeLayout2.setId(R.id.chat_item_content_layout);
        Resources resources = this.C.getResources();
        relativeLayout2.setPadding(resources.getDimensionPixelSize(R.dimen.f158199a4), resources.getDimensionPixelSize(R.dimen.f158201a6), resources.getDimensionPixelSize(R.dimen.f158197a3), resources.getDimensionPixelSize(R.dimen.f158200a5));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BaseChatItemLayout.f178056n0, -2);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.axw);
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        layoutParams.addRule(1, R.id.icon);
        relativeLayout2.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.C);
        linearLayout.setMinimumHeight(BaseAIOUtils.f(76.0f, this.C.getResources()));
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10, R.id.chat_item_content_layout);
        relativeLayout2.addView(linearLayout, layoutParams2);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.C);
        relativeLayout3.setId(R.id.c_t);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        relativeLayout3.setPadding(f16, f16, f16, 0);
        linearLayout.addView(relativeLayout3, layoutParams3);
        hVar.f().f32438h = relativeLayout3;
        int f18 = BaseAIOUtils.f(48.0f, this.C.getResources());
        AsyncImageView asyncImageView = new AsyncImageView(this.C);
        asyncImageView.setWidth(f18);
        asyncImageView.setHeight(f18);
        asyncImageView.setId(R.id.aud);
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(f18, f18);
        layoutParams4.addRule(11);
        layoutParams4.addRule(10);
        layoutParams4.setMargins(f16, 0, 0, 0);
        relativeLayout3.addView(asyncImageView, layoutParams4);
        hVar.f().f32439i = asyncImageView;
        EllipsizingTextView ellipsizingTextView = new EllipsizingTextView(this.C, null);
        ellipsizingTextView.setId(R.id.auf);
        ellipsizingTextView.setGravity(48);
        ellipsizingTextView.setIncludeFontPadding(false);
        ellipsizingTextView.setLineSpacing(0.0f, 1.0f);
        ellipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ellipsizingTextView.setTextSize(1, 17.0f);
        ellipsizingTextView.setMaxLines(2);
        ellipsizingTextView.setTextColor(Color.parseColor("#03081a"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(0, R.id.aud);
        layoutParams5.addRule(9);
        layoutParams5.addRule(10);
        relativeLayout3.addView(ellipsizingTextView, layoutParams5);
        hVar.f().f32434d = ellipsizingTextView;
        TextView textView = new TextView(this.C);
        textView.setId(R.id.auc);
        textView.setSingleLine();
        if (VersionUtils.isHoneycomb()) {
            textView.setAlpha(0.75f);
        }
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#777777"));
        textView.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(9);
        layoutParams6.addRule(3, R.id.auf);
        layoutParams6.setMargins(0, f17, 0, 0);
        relativeLayout3.addView(textView, layoutParams6);
        hVar.f().f32435e = textView;
        TextView textView2 = new TextView(this.C);
        textView2.setId(R.id.auh);
        textView2.setSingleLine();
        if (VersionUtils.isHoneycomb()) {
            textView2.setAlpha(0.75f);
        }
        textView2.setGravity(17);
        textView2.setTextColor(Color.parseColor("#777777"));
        textView2.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(1, R.id.auc);
        layoutParams7.addRule(8, R.id.auc);
        layoutParams7.setMargins(0, f17, 0, 0);
        relativeLayout3.addView(textView2, layoutParams7);
        hVar.f().f32436f = textView2;
        ProgressBar progressBar = new ProgressBar(this.C, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setId(R.id.aug);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(this.C.getResources().getDrawable(R.drawable.f160116am));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, BaseAIOUtils.f(2.0f, this.C.getResources()));
        layoutParams8.setMargins(f16, f17, f16, f17);
        linearLayout.addView(progressBar, layoutParams8);
        hVar.f().f32437g = progressBar;
        hVar.f().f32431a = relativeLayout2;
        hVar.f32392i.addView(relativeLayout2);
        if (i3 == 18) {
            M(inflate, hVar);
            L(inflate, hVar);
        } else {
            L(inflate, hVar);
        }
        hVar.o();
        return inflate;
    }

    @Override // com.dataline.util.DatalineSessionAdapter
    protected boolean o(int i3) {
        if (i3 != 17 && i3 != 18) {
            return false;
        }
        return true;
    }
}
