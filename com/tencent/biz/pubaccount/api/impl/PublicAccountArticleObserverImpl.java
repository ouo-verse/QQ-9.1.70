package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class PublicAccountArticleObserverImpl implements BusinessObserver, IPublicAccountArticleObserver {
    public static final String TAG = "Q.pubaccount.video.PublicAccountArticleObserver";
    private IPublicAccountArticleObserver.a mOnCallback;

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onCheckIsArticleLiked(boolean z16, String str, boolean z17) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.a(z16, str, z17);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onCreateArticleCommentRespond(boolean z16, int i3) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.b(z16, i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onGetArticleCommentCountRespond(boolean z16, int i3) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.c(z16, i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onGetArticleReadCount(boolean z16, int i3) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.d(z16, i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onGetPhotoCollectionInfoRespond(IPublicAccountImageCollectionUtils.a aVar) {
        IPublicAccountArticleObserver.a aVar2 = this.mOnCallback;
        if (aVar2 != null) {
            aVar2.e(aVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onGetRecommendInfoRespond(boolean z16, ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.g(z16, arrayList);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onQueryArticleLikeCount(boolean z16, String str, int i3) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.h(z16, str, i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onReportReadPhotoCollectionRespond(boolean z16) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.i(z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onSendArticleLikeReq(boolean z16, String str) {
        IPublicAccountArticleObserver.a aVar = this.mOnCallback;
        if (aVar != null) {
            aVar.j(z16, str);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 0) {
            if (obj != null && (obj instanceof Bundle)) {
                String string = ((Bundle) obj).getString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID);
                IPublicAccountArticleObserver.a aVar = this.mOnCallback;
                if (aVar != null) {
                    aVar.j(z16, string);
                    return;
                }
                return;
            }
            IPublicAccountArticleObserver.a aVar2 = this.mOnCallback;
            if (aVar2 != null) {
                aVar2.j(false, null);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (z16 && obj != null && (obj instanceof Bundle)) {
                Bundle bundle = (Bundle) obj;
                String string2 = bundle.getString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID);
                Boolean valueOf = Boolean.valueOf(bundle.getBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IS_LIKED));
                IPublicAccountArticleObserver.a aVar3 = this.mOnCallback;
                if (aVar3 != null) {
                    aVar3.a(true, string2, valueOf.booleanValue());
                    return;
                }
                return;
            }
            IPublicAccountArticleObserver.a aVar4 = this.mOnCallback;
            if (aVar4 != null) {
                aVar4.a(false, null, false);
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (z16 && obj != null && (obj instanceof Bundle)) {
                Bundle bundle2 = (Bundle) obj;
                String string3 = bundle2.getString(IPublicAccountArticleHandler.VALUE_ARTICLE_ID);
                int i16 = bundle2.getInt(IPublicAccountArticleHandler.VALUE_ARTICLE_LIKE_COUNT);
                IPublicAccountArticleObserver.a aVar5 = this.mOnCallback;
                if (aVar5 != null) {
                    aVar5.h(true, string3, i16);
                    return;
                }
                return;
            }
            IPublicAccountArticleObserver.a aVar6 = this.mOnCallback;
            if (aVar6 != null) {
                aVar6.h(false, null, 0);
                return;
            }
            return;
        }
        if (i3 != 4) {
            if (i3 != 7) {
                return;
            }
            if (z16 && obj != null && (obj instanceof Bundle)) {
                if (((Bundle) obj).getBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IMAGEE_IS_SUCCESS, false)) {
                    IPublicAccountArticleObserver.a aVar7 = this.mOnCallback;
                    if (aVar7 != null) {
                        aVar7.i(true);
                        return;
                    }
                    return;
                }
                IPublicAccountArticleObserver.a aVar8 = this.mOnCallback;
                if (aVar8 != null) {
                    aVar8.i(false);
                    return;
                }
                return;
            }
            IPublicAccountArticleObserver.a aVar9 = this.mOnCallback;
            if (aVar9 != null) {
                aVar9.i(false);
                return;
            }
            return;
        }
        if (z16 && obj != null && (obj instanceof Bundle)) {
            Bundle bundle3 = (Bundle) obj;
            if (bundle3.getBoolean(IPublicAccountArticleHandler.VALUE_ARTICLE_IMAGEE_IS_SUCCESS, false)) {
                int i17 = bundle3.getInt(IPublicAccountArticleHandler.VALUE_ARTICLE_COMMENT_COUNT);
                IPublicAccountArticleObserver.a aVar10 = this.mOnCallback;
                if (aVar10 != null) {
                    aVar10.c(true, i17);
                    return;
                }
                return;
            }
            IPublicAccountArticleObserver.a aVar11 = this.mOnCallback;
            if (aVar11 != null) {
                aVar11.c(false, 0);
                return;
            }
            return;
        }
        IPublicAccountArticleObserver.a aVar12 = this.mOnCallback;
        if (aVar12 != null) {
            aVar12.c(false, 0);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void setOnCallback(IPublicAccountArticleObserver.a aVar) {
        this.mOnCallback = aVar;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public void onGetPhotoCollectionInfoRespond(boolean z16, IPublicAccountImageCollectionUtils.a aVar, byte[] bArr, String str) {
        IPublicAccountArticleObserver.a aVar2 = this.mOnCallback;
        if (aVar2 != null) {
            aVar2.f(z16, aVar, bArr, str);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver
    public BusinessObserver getBusinessObserver() {
        return this;
    }
}
