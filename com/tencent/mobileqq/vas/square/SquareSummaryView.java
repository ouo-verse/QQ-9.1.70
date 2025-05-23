package com.tencent.mobileqq.vas.square;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareSummaryViewConfig;
import com.tencent.state.square.api.SummaryData;
import com.tencent.widget.SingleLineTextView;
import java.lang.Character;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010!\u001a\u00020\u0005\u00a2\u0006\u0004\b-\u0010.J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u001cR\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/square/SquareSummaryView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/state/square/api/ISquareSummaryView;", "Lcom/tencent/widget/SingleLineTextView;", "view", "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", DownloadInfo.spKey_Config, "", "d", "Lcom/tencent/state/square/api/SummaryData;", "summaryData", "g", "", "str", "", "isContainEmoji", "", "emoSize", "e", "c", "a", "getSummaryMsgText", "isContainerEmoji", "text", "setSummaryMsgText", "Landroid/view/View;", "getView", "setSummaryData", "", "b", "Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "getViewConfig", "()Lcom/tencent/state/square/api/SquareSummaryViewConfig;", "viewConfig", "Lcom/tencent/widget/SingleLineTextView;", "summaryView", "f", "Z", "hasEmoji", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "leftIcon", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/state/square/api/SquareSummaryViewConfig;)V", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareSummaryView extends LinearLayout implements ISquareSummaryView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final SquareSummaryViewConfig viewConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SingleLineTextView summaryView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasEmoji;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView leftIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareSummaryView(Context context, SquareSummaryViewConfig viewConfig) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewConfig, "viewConfig");
        this.viewConfig = viewConfig;
        setGravity(16);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        SingleLineTextView singleLineTextView = new SingleLineTextView(context);
        this.summaryView = singleLineTextView;
        singleLineTextView.setMaxWidth(ViewUtils.dpToPx(160.0f));
        d(singleLineTextView, viewConfig);
        singleLineTextView.setGravity(16);
        addView(singleLineTextView);
        ImageView imageView = new ImageView(context);
        this.leftIcon = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(13.0f), ViewUtils.dpToPx(13.0f));
        layoutParams.setMargins(0, 0, ViewUtils.dpToPx(4.0f), 0);
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        addView(imageView, 0, layoutParams);
    }

    private final void a(SummaryData summaryData) {
        int status = summaryData.getStatus();
        int i3 = R.drawable.qui_video_on_filled_feedback_success;
        switch (status) {
            case 1:
            case 2:
            case 3:
            case 5:
                i3 = R.drawable.qui_telephone_filled_feedback_success;
                break;
            case 4:
                i3 = R.drawable.conversation_unsend_icon;
                break;
            case 6:
                i3 = R.drawable.hmx;
                break;
            case 7:
                i3 = R.drawable.f160589hn0;
                break;
            case 8:
                i3 = R.drawable.hqy;
                break;
            case 9:
                i3 = R.drawable.hmy;
                break;
            case 10:
                i3 = R.drawable.mrs;
                break;
            case 11:
                i3 = R.drawable.f160583ms3;
                break;
            case 12:
            case 13:
                break;
            default:
                i3 = 0;
                break;
        }
        ImageView imageView = this.leftIcon;
        if (imageView != null) {
            if (summaryData.isTroop()) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = ViewUtils.dpToPx(14.0f);
                layoutParams.height = ViewUtils.dpToPx(14.0f);
            }
            if (i3 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageDrawable(getResources().getDrawable(i3));
                imageView.setVisibility(0);
            }
        }
    }

    private final void e(String str, boolean isContainEmoji, int emoSize) {
        SingleLineTextView singleLineTextView;
        this.hasEmoji = isContainEmoji;
        if (isContainEmoji) {
            if (c(str) && (singleLineTextView = this.summaryView) != null) {
                singleLineTextView.setPadding(0, 0, 0, ViewUtils.dpToPx(2.0f));
            }
            SingleLineTextView singleLineTextView2 = this.summaryView;
            if (singleLineTextView2 == null) {
                return;
            }
            singleLineTextView2.setText(new QQText(str, 3, emoSize));
            return;
        }
        SingleLineTextView singleLineTextView3 = this.summaryView;
        if (singleLineTextView3 != null) {
            singleLineTextView3.setPadding(0, 0, 0, 0);
        }
        SingleLineTextView singleLineTextView4 = this.summaryView;
        if (singleLineTextView4 == null) {
            return;
        }
        singleLineTextView4.setText(str);
    }

    private final void g(SummaryData summaryData, SquareSummaryViewConfig config) {
        float textSize;
        SingleLineTextView singleLineTextView = this.summaryView;
        if (singleLineTextView != null) {
            String highText = summaryData.getHighText();
            if (highText == null) {
                highText = "";
            }
            singleLineTextView.setExtendText(highText, 1);
            singleLineTextView.setExtendTextColor(ColorStateList.valueOf(summaryData.getHighColor()), 1);
            if (config != null) {
                textSize = config.getTextSize();
            } else {
                textSize = this.viewConfig.getTextSize();
            }
            singleLineTextView.setExtendTextSize(textSize, 1);
        }
    }

    public final boolean b(char c16) {
        Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
        return of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of5 == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of5 == Character.UnicodeBlock.GENERAL_PUNCTUATION || of5 == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of5 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    @Override // com.tencent.state.square.api.ISquareSummaryView
    public String getSummaryMsgText() {
        CharSequence text;
        String obj;
        SingleLineTextView singleLineTextView = this.summaryView;
        return (singleLineTextView == null || (text = singleLineTextView.getText()) == null || (obj = text.toString()) == null) ? "" : obj;
    }

    @Override // com.tencent.state.square.api.ISquareSummaryView
    /* renamed from: isContainerEmoji, reason: from getter */
    public boolean getHasEmoji() {
        return this.hasEmoji;
    }

    @Override // com.tencent.state.square.api.ISquareSummaryView
    public void setSummaryData(SummaryData summaryData, SquareSummaryViewConfig config) {
        Intrinsics.checkNotNullParameter(summaryData, "summaryData");
        if (this.summaryView == null) {
            return;
        }
        g(summaryData, config);
        d(this.summaryView, config);
        a(summaryData);
        String msgText = summaryData.getMsgText();
        if (msgText == null || msgText.length() == 0) {
            msgText = "\u67e5\u770b\u6d88\u606f";
        }
        e(msgText, summaryData.isContainEmoji(), summaryData.isTroop() ? 13 : 15);
        invalidate();
    }

    @Override // com.tencent.state.square.api.ISquareSummaryView
    public void setSummaryMsgText(String text, boolean isContainEmoji) {
        Intrinsics.checkNotNullParameter(text, "text");
        f(this, text, isContainEmoji, 0, 4, null);
    }

    private final boolean c(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt < '\u0080' || b(charAt)) {
                return true;
            }
        }
        return false;
    }

    private final void d(SingleLineTextView view, SquareSummaryViewConfig config) {
        if (view == null || config == null) {
            return;
        }
        view.setTextSize(config.getTextSize());
        view.setTextColor(config.getNormalTextColor());
    }

    static /* synthetic */ void f(SquareSummaryView squareSummaryView, String str, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 13;
        }
        squareSummaryView.e(str, z16, i3);
    }

    @Override // com.tencent.state.square.api.ISquareSummaryView
    public View getView() {
        return this;
    }
}
