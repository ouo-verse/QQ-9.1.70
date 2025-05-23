package com.tencent.qq.minibox.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qq.minibox.permission.PermissionItem;
import java.util.List;
import mqq.app.api.IRuntimeService;
import os3.a;

@Service(needUin = false, process = {"all"})
/* loaded from: classes22.dex */
public interface IGamePermissionManagerService extends IRuntimeService {
    public static final String INTENT_KEY_GAME_ID = "intent_key_game_id";
    public static final String INTENT_KEY_GAME_NAME = "intent_key_game_name";
    public static final String PERMISSION_TAG = "game.permission.";

    void clearPermissionStatusAsyn(String str);

    List<a> getGamePermissionItems(String str);

    PermissionItem getPermissionItem(String str);

    boolean isPermissionDefined(String str);

    int queryPermissionStatus(String str, String str2);

    void showPermissionConfirmDialog(Activity activity, Drawable drawable, String str, String str2, String str3, bs3.a aVar);

    void showPermissionConfirmDialog(Activity activity, String str, String str2, String str3, String str4, bs3.a aVar);

    void startPermissionSettingFragment(Context context, Intent intent);

    void updateGamePermission(String str, String str2, int i3);
}
