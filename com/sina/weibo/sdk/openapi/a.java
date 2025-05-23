package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.a;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.ShareStoryActivity;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.f;
import com.sina.weibo.sdk.web.b.d;
import com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a implements IWBAPI {
    private Context mContext;

    /* renamed from: t, reason: collision with root package name */
    private com.sina.weibo.sdk.auth.a f61268t;

    /* renamed from: u, reason: collision with root package name */
    private f f61269u;

    public a(Context context) {
        this.mContext = context;
        this.f61268t = new com.sina.weibo.sdk.auth.a((Activity) context);
        this.f61269u = new f((Activity) this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(WbAuthListener wbAuthListener) {
        boolean z16;
        com.sina.weibo.sdk.auth.a aVar = this.f61268t;
        c.a("WBSsoTag", "authorize()");
        if (wbAuthListener != null) {
            aVar.f61226h = wbAuthListener;
            Activity activity = aVar.f61225g.get();
            if (com.sina.weibo.sdk.a.a(activity)) {
                if (com.sina.weibo.sdk.c.a.c(activity) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    aVar.d();
                    return;
                }
            }
            aVar.e();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(int i3, int i16, Intent intent) {
        com.sina.weibo.sdk.auth.a aVar = this.f61268t;
        c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = aVar.f61226h;
        if (wbAuthListener != null) {
            if (32973 == i3) {
                if (i16 == -1) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("error");
                        String stringExtra2 = intent.getStringExtra(QQGameReportServiceImpl.ATTA_KEY_ERROR_TYPE);
                        String stringExtra3 = intent.getStringExtra("error_description");
                        if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                            Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                            if (parseAccessToken != null) {
                                AccessTokenHelper.writeAccessToken(aVar.f61225g.get(), parseAccessToken);
                                aVar.f61226h.onComplete(parseAccessToken);
                                return;
                            } else {
                                aVar.f61226h.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                                return;
                            }
                        }
                        if (!"access_denied".equals(stringExtra) && !"OAuthAccessDeniedException".equals(stringExtra)) {
                            aVar.f61226h.onError(new UiError(-5, stringExtra2, stringExtra3));
                            return;
                        } else {
                            aVar.f61226h.onCancel();
                            return;
                        }
                    }
                    return;
                }
                if (i16 == 0) {
                    wbAuthListener.onCancel();
                    return;
                } else {
                    wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
                    return;
                }
            }
            wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f61268t;
        c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener != null) {
            aVar.f61226h = wbAuthListener;
            aVar.d();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f61268t;
        c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener != null) {
            aVar.f61226h = wbAuthListener;
            aVar.e();
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        if (intent != null && wbShareCallback != null && (extras = intent.getExtras()) != null) {
            try {
                int i3 = extras.getInt("_weibo_resp_errcode", -1);
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            wbShareCallback.onError(new UiError(i3, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
                            return;
                        }
                        return;
                    }
                    wbShareCallback.onCancel();
                    return;
                }
                wbShareCallback.onComplete();
            } catch (Exception e16) {
                wbShareCallback.onError(new UiError(-1, e16.getMessage(), e16.getMessage()));
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(Context context, AuthInfo authInfo) {
        com.sina.weibo.sdk.a.a(context, authInfo);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z16) {
        c.setLoggerEnable(z16);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z16) {
        AuthInfo a16;
        boolean z17;
        f fVar = this.f61269u;
        Activity activity = fVar.f61282g.get();
        if (activity != null) {
            if (com.sina.weibo.sdk.a.a(activity) || !z16) {
                if (z16) {
                    fVar.b(weiboMultiMessage);
                    return;
                }
                a.C0511a c16 = com.sina.weibo.sdk.c.a.c(activity);
                if (com.sina.weibo.sdk.a.a(activity) && c16 != null) {
                    a.C0511a c17 = com.sina.weibo.sdk.c.a.c(activity);
                    if (c17 != null && c17.f61248an > 10000) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        fVar.b(weiboMultiMessage);
                        return;
                    }
                }
                Activity activity2 = fVar.f61282g.get();
                if (activity2 != null && (a16 = com.sina.weibo.sdk.a.a()) != null) {
                    d dVar = new d(a16);
                    dVar.setContext(activity2);
                    dVar.aK = weiboMultiMessage;
                    dVar.packageName = activity2.getPackageName();
                    Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity2);
                    if (readAccessToken != null) {
                        String accessToken = readAccessToken.getAccessToken();
                        if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                            dVar.f61292ak = accessToken;
                        }
                    }
                    Bundle bundle = new Bundle();
                    dVar.writeToBundle(bundle);
                    Intent intent = new Intent(activity2, (Class<?>) ShareTransActivity.class);
                    intent.putExtra("start_flag", 0);
                    intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                    intent.putExtras(bundle);
                    activity2.startActivityForResult(intent, 10001);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareStory(StoryMessage storyMessage) {
        Activity activity = this.f61269u.f61282g.get();
        if (activity != null) {
            Uri imageUri = storyMessage.getImageUri();
            Uri videoUri = storyMessage.getVideoUri();
            if (imageUri != null) {
                try {
                    if (!b.a(activity, imageUri)) {
                    }
                    Intent intent = new Intent();
                    intent.putExtra("_weibo_message_stroy", storyMessage);
                    intent.putExtra("start_flag", 0);
                    intent.setClass(activity, ShareStoryActivity.class);
                    activity.startActivityForResult(intent, 10001);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (videoUri == null || !b.b(activity, videoUri)) {
                throw new IllegalStateException("File only can be Image or Video. ");
            }
            Intent intent2 = new Intent();
            intent2.putExtra("_weibo_message_stroy", storyMessage);
            intent2.putExtra("start_flag", 0);
            intent2.setClass(activity, ShareStoryActivity.class);
            activity.startActivityForResult(intent2, 10001);
        }
    }
}
