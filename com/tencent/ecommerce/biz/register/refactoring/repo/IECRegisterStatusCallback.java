package com.tencent.ecommerce.biz.register.refactoring.repo;

import com.tencent.ecommerce.repo.register.ECMsgBox;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterStatusCallback;", "", "onCheck", "", "isRegistered", "", "mediaID", "", "role", "", "msgBox", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECRegisterStatusCallback {
    void onCheck(boolean isRegistered, String mediaID, int role, ECMsgBox msgBox);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(IECRegisterStatusCallback iECRegisterStatusCallback, boolean z16, String str, int i3, ECMsgBox eCMsgBox, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                if ((i16 & 8) != 0) {
                    eCMsgBox = null;
                }
                iECRegisterStatusCallback.onCheck(z16, str, i3, eCMsgBox);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCheck");
        }
    }
}
