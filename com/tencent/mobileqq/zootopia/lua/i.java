package com.tencent.mobileqq.zootopia.lua;

import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\\\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/i;", "", "", "enterAvatarResidence", "", IZootopiaShareArkService.ARK_MAP_ID, "", "extras", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "retCode", "serverCode", "callback", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface i {
    void a(int mapID, String extras, boolean needDownload, Function2<? super Integer, ? super Integer, Unit> callback);

    void enterAvatarResidence();
}
