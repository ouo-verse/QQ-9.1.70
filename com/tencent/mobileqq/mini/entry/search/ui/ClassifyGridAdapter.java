package com.tencent.mobileqq.mini.entry.search.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ClassifyGridAdapter extends BaseAdapter {
    private ArrayList<SearchClassifyData> mClassify = new ArrayList<>();
    private OnClassifyClickListener mClickListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mini.entry.search.ui.ClassifyGridAdapter$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify;

        static {
            int[] iArr = new int[SearchClassifyData.Classify.values().length];
            $SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify = iArr;
            try {
                iArr[SearchClassifyData.Classify.GAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify[SearchClassifyData.Classify.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify[SearchClassifyData.Classify.SOCIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify[SearchClassifyData.Classify.ENTERTAINMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface OnClassifyClickListener {
        void onClick(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class SearchClassifyData {
        public Classify classify;
        public int icon;
        public String title;
        public static final String GAME = HardCodeUtil.qqStr(R.string.f167462d0);
        public static final String SERVICE = HardCodeUtil.qqStr(R.string.f167472d1);
        public static final String SOCIAL = HardCodeUtil.qqStr(R.string.f167482d2);
        public static final String ENTERTAINMENT = HardCodeUtil.qqStr(R.string.f167452cz);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public enum Classify {
            GAME,
            SERVICE,
            SOCIAL,
            ENTERTAINMENT
        }

        public SearchClassifyData(int i3, String str, Classify classify) {
            this.icon = i3;
            this.title = str;
            this.classify = classify;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getView$0(int i3, View view) {
        reportIconEvent(this.mClassify.get(i3).classify, "em_click");
        OnClassifyClickListener onClassifyClickListener = this.mClickListener;
        if (onClassifyClickListener != null) {
            onClassifyClickListener.onClick(this.mClassify.get(i3).title);
        }
    }

    private void reportIconEvent(SearchClassifyData.Classify classify, String str) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$mobileqq$mini$entry$search$ui$ClassifyGridAdapter$SearchClassifyData$Classify[classify.ordinal()];
        if (i3 == 1) {
            MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", str, MiniProgramLpReportDC04239.SORT_SELECTED_GAME, MiniProgramLpReportDC04239.SORT_PAGE_REFER, MiniProgramLpReportDC04239.SORT_PAGE_VIA_GAME);
            return;
        }
        if (i3 == 2) {
            MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", str, MiniProgramLpReportDC04239.SORT_SELECTED_SERVICE, MiniProgramLpReportDC04239.SORT_PAGE_REFER, MiniProgramLpReportDC04239.SORT_PAGE_VIA_SERVICE);
        } else if (i3 == 3) {
            MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", str, MiniProgramLpReportDC04239.SORT_SELECTED_SOCIAL, MiniProgramLpReportDC04239.SORT_PAGE_REFER, MiniProgramLpReportDC04239.SORT_PAGE_VIA_SOCIAL);
        } else {
            if (i3 != 4) {
                return;
            }
            MiniProgramLpReportDC04239.reportAsyncWithReferAndVia("page_view", str, MiniProgramLpReportDC04239.SORT_SELECTED_ENTERTAINMENT, MiniProgramLpReportDC04239.SORT_PAGE_REFER, MiniProgramLpReportDC04239.SORT_PAGE_VIA_ENTERTAINMENT);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mClassify.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.mClassify.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public void initData() {
        this.mClassify.add(new SearchClassifyData(R.drawable.qui_game, SearchClassifyData.GAME, SearchClassifyData.Classify.GAME));
        this.mClassify.add(new SearchClassifyData(R.drawable.qui_service, SearchClassifyData.SERVICE, SearchClassifyData.Classify.SERVICE));
        this.mClassify.add(new SearchClassifyData(R.drawable.qui_greeting, SearchClassifyData.SOCIAL, SearchClassifyData.Classify.SOCIAL));
        this.mClassify.add(new SearchClassifyData(R.drawable.qui_video_on, SearchClassifyData.ENTERTAINMENT, SearchClassifyData.Classify.ENTERTAINMENT));
    }

    public void setOnClassifyClickListener(OnClassifyClickListener onClassifyClickListener) {
        this.mClickListener = onClassifyClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(final int i3, View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.djf, viewGroup, false);
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.f163695ri2);
        TextView textView = (TextView) inflate.findViewById(R.id.f163696ri3);
        uRLImageView.setImageDrawable(AppCompatResources.getDrawable(inflate.getContext(), this.mClassify.get(i3).icon));
        textView.setText(this.mClassify.get(i3).title);
        textView.setAlpha(0.7f);
        uRLImageView.setAlpha(0.7f);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.search.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClassifyGridAdapter.this.lambda$getView$0(i3, view2);
            }
        });
        reportIconEvent(this.mClassify.get(i3).classify, "em_expo");
        return inflate;
    }
}
