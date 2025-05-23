package com.tencent.ttpic.openapi.shader;

import com.tencent.aekit.openrender.internal.Shader;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ShaderManager {
    private static final ThreadLocal<ShaderManager> shaderManager = new ThreadLocal<ShaderManager>() { // from class: com.tencent.ttpic.openapi.shader.ShaderManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ShaderManager initialValue() {
            return new ShaderManager();
        }
    };
    private Map<ShaderCreateFactory.PROGRAM_TYPE, Shader> shaderMap = new HashMap();

    public static ShaderManager getInstance() {
        return shaderManager.get();
    }

    public boolean bind(ShaderCreateFactory.PROGRAM_TYPE program_type) {
        Shader shader = this.shaderMap.get(program_type);
        if (shader == null) {
            return false;
        }
        shader.bind();
        return true;
    }

    public void clear() {
        Iterator<Shader> it = this.shaderMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.shaderMap.clear();
    }

    public boolean clearShader(ShaderCreateFactory.PROGRAM_TYPE program_type) {
        Shader shader = this.shaderMap.get(program_type);
        if (shader == null) {
            return false;
        }
        shader.clear();
        this.shaderMap.remove(program_type);
        return true;
    }

    public void compile() {
        Iterator<Shader> it = this.shaderMap.values().iterator();
        while (it.hasNext()) {
            it.next().compile();
        }
    }

    public Shader getShader(ShaderCreateFactory.PROGRAM_TYPE program_type) {
        if (!this.shaderMap.containsKey(program_type)) {
            this.shaderMap.put(program_type, ShaderCreateFactory.createShader(program_type));
        }
        return this.shaderMap.get(program_type);
    }
}
