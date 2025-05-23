package com.tencent.ecommerce.base.list;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/base/list/IStateCenterView;", "", "setEmptyState", "", "description", "", "token", "backgroundColor", "", "setFailedState", "errorMsg", "setLoadingState", "loadingTip", "setSucceededState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IStateCenterView {
    void setEmptyState(String description, String token, int backgroundColor);

    void setFailedState(String errorMsg);

    void setLoadingState(String loadingTip);

    void setSucceededState();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class a {
        public static /* synthetic */ void a(IStateCenterView iStateCenterView, String str, String str2, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    str = "";
                }
                if ((i16 & 2) != 0) {
                    str2 = "qecommerce_skin_emptystate_img_dongtai";
                }
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iStateCenterView.setEmptyState(str, str2, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEmptyState");
        }

        public static /* synthetic */ void b(IStateCenterView iStateCenterView, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                iStateCenterView.setFailedState(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFailedState");
        }

        public static /* synthetic */ void c(IStateCenterView iStateCenterView, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                iStateCenterView.setLoadingState(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadingState");
        }
    }
}
