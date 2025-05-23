package com.qzone.reborn.feedx.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.mobileqq.R;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ce extends g {
    private String b0(BusinessFeedData businessFeedData) {
        Iterator<Object> it = businessFeedData.getDetailContent().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof PictureItem) {
                PictureItem pictureItem = (PictureItem) next;
                if (pictureItem.getCurrentUrl() != null && !TextUtils.isEmpty(pictureItem.getCurrentUrl().url)) {
                    return pictureItem.getCurrentUrl().url;
                }
            }
        }
        return "";
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void J(BusinessFeedData businessFeedData, View view) {
        U(businessFeedData.getOriginalInfo(), view);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void L(BusinessFeedData businessFeedData) {
        Y(businessFeedData);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void M(BusinessFeedData businessFeedData) {
        Z(businessFeedData);
    }

    @Override // com.qzone.reborn.feedx.presenter.al
    protected void N(BusinessFeedData businessFeedData) {
        a0(businessFeedData);
        ConstraintLayout constraintLayout = this.F;
        if (constraintLayout != null) {
            constraintLayout.setBackgroundResource(R.drawable.f15153m);
        }
    }

    @Override // com.qzone.reborn.feedx.presenter.g
    String R(BusinessFeedData businessFeedData) {
        PictureUrl pictureUrl;
        if (businessFeedData == null) {
            return "";
        }
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if (originalInfo != null) {
            String S = S(originalInfo);
            if (!TextUtils.isEmpty(S)) {
                return S;
            }
        }
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().photoUrl != null && (pictureUrl = businessFeedData.getOperationInfoV2().photoUrl.get(-1)) != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return pictureUrl.url;
        }
        if (originalInfo != null && !com.tencent.mobileqq.utils.bl.b(originalInfo.getDetailContent())) {
            String b06 = b0(originalInfo);
            if (!TextUtils.isEmpty(b06)) {
                return b06;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.presenter.al
    public boolean I(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        return T(businessFeedData.getOriginalInfo());
    }
}
