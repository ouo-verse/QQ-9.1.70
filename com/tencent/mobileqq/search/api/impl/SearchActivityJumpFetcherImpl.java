package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchActivityJumpFetcherImpl implements ISearchActivityJumpFetcher {
    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToActiveEntitySearchActivity(Context context, String str, String str2, long[] jArr) {
        ActiveEntitySearchActivity.c3(context, str, str2, jArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToContactSearchActivity(Context context, String str, int i3, int i16) {
        ContactSearchActivity.Q2(context, str, i3, 100860733, i16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToFavoriteSearchActivity(Context context, String str) {
        FavoriteSearchActivity.launch(context, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToFileSearchActivity(Context context, String str, List<y> list, boolean z16, int i3) {
        FileSearchActivity.W2(context, str, list, z16, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToFunctionSearchActivity(Context context, String str) {
        FunctionSearchActivity.launch(context, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToMessageSearchActivity(Context context, String str) {
        MessageSearchActivity.launch(context, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToNtContactSearchActivity(Context context, String str, int i3, int i16) {
        ContactSearchActivity.R2(context, str, i3, 100860733, i16);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToProfileCardActivity(Activity activity, SearchResultItem searchResultItem, AppInterface appInterface, boolean z16, int i3) {
        AddFriendActivity.startProfileCardActivity(activity, searchResultItem, (QQAppInterface) appInterface, z16, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToPublicAcntSearchActivity(Context context, String str, int i3) {
        PublicAcntSearchActivity.P2(context, str, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToQQBrowserActivity(Context context, Map<String, String> map) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        for (String str : map.keySet()) {
            intent.putExtra(str, map.get(str));
        }
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToSearchBaseActivity(Context context, String str, int i3) {
        Intent intent = new Intent(context, (Class<?>) SearchContactsActivity.class);
        intent.putExtra("start_search_key", str);
        intent.putExtra("jump_src_key", 0);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, i3);
        context.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
    public void jumpToTroopInfoActivity(Context context, Bundle bundle, int i3) {
        TroopUtils.I(context, bundle, i3);
    }
}
