package com.tencent.aelight.camera.favemoticon.api.impl;

import com.tencent.aelight.camera.favemoticon.api.IFavEmoticonIPCServerApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import fr.d;

/* loaded from: classes32.dex */
public class FavEmoticonIPCServerApiImpl implements IFavEmoticonIPCServerApi {
    @Override // com.tencent.aelight.camera.favemoticon.api.IFavEmoticonIPCServerApi
    public QIPCModule getFavEmoticonIPCModule() {
        return d.c();
    }
}
