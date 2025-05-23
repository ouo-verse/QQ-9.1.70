package com.qzone.module.feedcomponent.ui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.NewGuideView;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class NewGuideCanvasViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).button = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("subSummary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).subSummary = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("summary", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).summary = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("rightIcon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).rightIcon = (DittoImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((NewGuideView.NewGuideCanvasView) dittoAreaView).onFeedbackClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("moreIndicatorText", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).moreIndicatorText = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("leftTitle", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).leftTitle = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.7.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((NewGuideView.NewGuideCanvasView) dittoAreaView).onRootClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("moreIndicator", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).moreIndicator = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.8.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((NewGuideView.NewGuideCanvasView) dittoAreaView).onMoreClicked(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("moreIndicatorIcon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).moreIndicatorIcon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put(IndividuationUrlHelper.UrlId.CARD_HOME, new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).card = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.10.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((NewGuideView.NewGuideCanvasView) dittoAreaView).onCardClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("contentBackgroundImage", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).contentBackgroundImage = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("avatars", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.NewGuideCanvasViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((NewGuideView.NewGuideCanvasView) dittoAreaView).avatars = (DittoListArea) dittoArea;
                }
            });
            ID_FUNC_POLY = new DittoIdFuncPoly(hashMap);
        }

        Holder() {
        }
    }

    @Override // com.tencent.ditto.func.DittoIdFuncPolyProxy
    protected DittoIdFuncPoly getIdFuncPoly() {
        return Holder.ID_FUNC_POLY;
    }
}
