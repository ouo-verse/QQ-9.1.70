package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedCanvasAdRecommAction extends CanvasRecommAction {
    public static FeedViewSection.SectionController AdRecommActionController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedCanvasAdRecommAction.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return !GdtAdFeedUtil.isSectionVisible(businessFeedData, ViewSectionType.RECOMM_ACTION) || businessFeedData == null || businessFeedData.getRecommAction() == null || !businessFeedData.isCanvasAd();
        }
    };
    private static final String TAG = "FeedCanvasAdRecommAction";
    private LinearLayout container;
    private Context context;
    private BusinessFeedData feedData;
    private AnimationDrawable frameAnim;
    private boolean initialized;
    private ImageView openAnimView;
    private TextView openTV;

    public FeedCanvasAdRecommAction(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean hasUsed() {
        return this.used;
    }

    public void setUsed(boolean z16) {
        this.used = z16;
    }
}
