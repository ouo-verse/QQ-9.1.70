package com.qzone.module.feedcomponent.ui.canvasui;

import android.view.MotionEvent;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.func.DittoIdFunc;
import com.tencent.ditto.func.DittoIdFuncPoly;
import com.tencent.ditto.func.DittoIdFuncPolyProxy;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoTextArea;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class CanvasPublicAccountContainerViewIdFuncPoly extends DittoIdFuncPolyProxy {

    /* loaded from: classes39.dex */
    private static class Holder {
        private static final DittoIdFuncPoly ID_FUNC_POLY;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("account_desc", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.1
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mAccountDesc = (DittoTextArea) dittoArea;
                }
            });
            hashMap.put("card_root", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.2
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mRoot = dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.2.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasPublicAccountContainerView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("account_logo", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.3
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mAccountLogo = (AsyncCanvasImageArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.3.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasPublicAccountContainerView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("account_name", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.4
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mAccountName = (DittoTextArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.4.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasPublicAccountContainerView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("jump_button", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.5
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(final DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mJumpButton = (DittoButtonArea) dittoArea;
                    dittoArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.5.1
                        @Override // com.tencent.ditto.area.DittoArea.ClickListener
                        public void onClick(DittoArea dittoArea2, MotionEvent motionEvent, Object obj) {
                            ((CanvasPublicAccountContainerView) dittoAreaView).onClick(dittoArea2, motionEvent, obj);
                        }
                    };
                }
            });
            hashMap.put("icon_vip", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.6
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mVipIcon = (AsyncCanvasImageArea) dittoArea;
                }
            });
            hashMap.put("btn_close", new DittoIdFunc() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerViewIdFuncPoly.Holder.7
                @Override // com.tencent.ditto.func.DittoIdFunc
                public void inflate(DittoAreaView dittoAreaView, DittoArea dittoArea) {
                    ((CanvasPublicAccountContainerView) dittoAreaView).mBtnClose = (AsyncCanvasImageArea) dittoArea;
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
