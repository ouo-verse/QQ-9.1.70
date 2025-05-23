package com.qzone.module.feedcomponent.ui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.BirthdayCardFeedView;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasBirthdayViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("moreIcon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).moreIcon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("birthdayCardCheckTitle", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardCheckTitle = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("birthdayRootContainer", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayRootContainer = (RelativeAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayRootContainerClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("birthdayCardBg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardBg = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("birthdayCardButton", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardButton = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardButtonClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("birthdayCardCheckLin", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardCheckLin = (LinearAreaLayout) dittoArea;
                }
            });
            hashMap.put("birthdayCardTitle", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardTitle = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("birthdayRootBg", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.8
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayRootBg = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("moreTitle", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.9
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).moreTitle = (RichCanvasTextArea) dittoArea;
                }
            });
            hashMap.put("birthdayCardButtonClicked", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.10
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardButtonClicked = (DittoButtonArea) dittoArea;
                }
            });
            hashMap.put("moreLin", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.11
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).moreLin = (LinearAreaLayout) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.11.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).moreLinClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("birthdayCardIcon", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.12
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardIcon = (CanvasAvatarArea) dittoArea;
                }
            });
            hashMap.put("birthdayCardUnSelect", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.13
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardUnSelect = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.13.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardUnSelectClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("birthdayCardClose", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.14
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardClose = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.14.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardCloseClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("birthdayCardSelect", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.15
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardSelect = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.CanvasBirthdayViewIdFuncPoly.Holder.15.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((BirthdayCardFeedView.CanvasBirthdayView) dittoAreaView).birthdayCardCheckClick(dittoArea2, motionEvent, obj);
                        }
                    };
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
