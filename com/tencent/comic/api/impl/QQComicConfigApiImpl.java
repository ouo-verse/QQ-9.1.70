package com.tencent.comic.api.impl;

import android.content.Context;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.comic.config.QQComicConfBean;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.common.app.AppInterface;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicConfigApiImpl implements IQQComicConfigApi {
    @Override // com.tencent.comic.api.IQQComicConfigApi
    public List<ComicCancelRedPointPopItemData> getCancelRedPointDialogDefaultData() {
        return QQComicConfBean.a().list;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public int getCancelRedPointPopDayCount() {
        return QQComicConfBean.a().dayCount;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public int getReaderPreloadNum() {
        return QQComicConfBean.d().preloadNum;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean getSectionCommentMasterSwitch() {
        return QQComicConfBean.d().sectionCommentMasterSwitch;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public int getSectionCommentNumVS() {
        return QQComicConfBean.d().sectionCommentNumVS;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isEnableCancelRedPointDataCache() {
        return QQComicConfBean.a().enableLocalCache == 1;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isEnableShowCancelRedPointDialog() {
        return QQComicConfBean.a().popSwitch == 1;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isIgnoreInteractiveControll() {
        return QQComicConfBean.a().ignoreInteractiveControll == 1;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isIgnoreReddotControll() {
        return QQComicConfBean.a().ignoreRedDot == 1;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isMatched(String str) {
        return false;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isReaderEnablePreload() {
        return QQComicConfBean.d().enablePreload;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean isReaderEnablePreread() {
        return QQComicConfBean.d().enablePreRead;
    }

    @Override // com.tencent.comic.api.IQQComicConfigApi
    public boolean launchIfMatched(String str, Context context, int i3, AppInterface appInterface) {
        return QQComicConfBean.f().f(str, context, i3, appInterface);
    }
}
